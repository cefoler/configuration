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

if [ -z "$1" ]; then
  while [ -z "$request" ]; do
    read -p "Enter the JDK version to install: " request
    VERSION=$request
  done
else
  VERSION=$1
fi

REGEX="[0-9]+"

while [[ ! $VERSION =~ $REGEX ]]; do
  read -p "Invalid JDK version, please enter a valid JDK version: " request
  VERSION=$request
done

URL="https://corretto.aws/downloads/latest/amazon-corretto-$VERSION-x64-linux-jdk.tar.gz"
CODE=$(curl --write-out %{http_code} --silent --output /dev/null "$URL")

if [ "$CODE" -ne 200 ]; then
  die "Failed to make the request to $URL"
  exit 1
fi

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
