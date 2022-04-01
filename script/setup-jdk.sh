#!/usr/bin/env sh

warn() {
  echo "$*"
}

die() {
  echo ""
  echo "$*"
  echo ""

  exit 1
}

VERSION="$1"
REGEX="[0-9]+"

if [[ ! $VERSION =~ $REGEX ]]; then
  die "Invalid JDK version: $VERSION"
fi

URL="https://corretto.aws/downloads/latest/amazon-corretto-$VERSION-x64-linux-jdk.tar.gz"

FILE="amazon-corretto-$VERSION-x64-linux-jdk.tar.gz"
DIRECTORY="/usr/lib/jvm/java-$VERSION-amazon-corretto"

echo "Downloading JDK $VERSION..."
wget "$URL"

echo "Downloaded JDK $VERSION"
echo "Extracting JDK $VERSION..."

mkdir -p "$DIRECTORY"

tar -xzf "$FILE" -C "$DIRECTORY" --strip-components=1
rm -rf "$FILE"

export JAVA_HOME="$DIRECTORY/bin/java"
export PATH=$PATH:"$DIRECTORY/bin"

if [ $? -eq 0 ]; then
  echo "JDK $VERSION installed."
else
  warn "Failed to download JDK $VERSION."
fi
