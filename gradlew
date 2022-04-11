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

JVM_OPTS="-Xms500M -Xmx2G -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8"

NAME="Gradle"
BASE=$(basename "$0")

FILE_DESCRIPTOR="maximum"

CYGWIN=false
MSYS=false
DARWIN=false
NONSTOP=false

case $(uname) in
  CYGWIN*) CYGWIN=true ;;
  DARWIN*) DARWIN=true ;;
  MSYS* | MINGW*) MSYS=true ;;
  NONSTOP*) NONSTOP=true ;;
esac

if [ $CYGWIN = false ] && [ $DARWIN = false ] && [ $NONSTOP = false ]; then
  FILE_DESCRIPTOR_LIMIT=$(ulimit -H -n)

  if [ $? -eq 0 ]; then
    if [ "$FILE_DESCRIPTOR" = "maximum" ]; then
      FILE_DESCRIPTOR="$FILE_DESCRIPTOR_LIMIT"
    fi

    ulimit -n "$FILE_DESCRIPTOR"

    if [ $? -ne 0 ]; then
      warn "Could not set maximum file descriptor limit: $FILE_DESCRIPTOR"
    fi
  else
    warn "Could not query maximum file descriptor limit: $FILE_DESCRIPTOR_LIMIT"
  fi
fi

if [ $DARWIN = true ]; then
  GRADLE_OPTS="$GRADLE_OPTS \"-Xdock:name=$NAME\" \"-Xdock:icon=$HOME/media/gradle.icns\""
fi

if [ "$CYGWIN" = true ] || [ "$MSYS" = true ]; then
  HOME=$(cygpath --path --mixed "$HOME")
  WRAPPER=$(cygpath --path --mixed "$WRAPPER")
  COMMAND=$(cygpath --unix "$COMMAND")

  RAW=$(find -L / -maxdepth 1 -mindepth 1 -type d 2> "/dev/null")
  SEP=""

  for directory in $RAW; do
    ROOT="$ROOT$SEP$directory"
    SEP="|"
  done

  PATTERN="(^($ROOT))"

  if [ -n "$GRADLE_CYGPATTERN" ]; then
    PATTERN="$PATTERN|($GRADLE_CYGPATTERN)"
  fi

  index=0

  for arg in "$@"; do
    CHECK1=$(echo "$arg" | grep -c "$PATTERN" -)
    CHECK2=$(echo "$arg" | grep -c "^-")

    if [ "$CHECK1" -ne 0 ] && [ "$CHECK2" -eq 0 ]; then
      eval $(echo "args$index")=$(cygpath --path --ignore --mixed "$arg")
    else
      eval $(echo "args$index")="\"$arg\""
    fi

    index=$(expr $index + 1)
  done

  case $index in
    0) set -- ;;
    1) set -- "$args0" ;;
    2) set -- "$args0" "$args1" ;;
    3) set -- "$args0" "$args1" "$args2" ;;
    4) set -- "$args0" "$args1" "$args2" "$args3" ;;
    5) set -- "$args0" "$args1" "$args2" "$args3" "$args4" ;;
    6) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" ;;
    7) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" "$args6" ;;
    8) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" "$args6" "$args7" ;;
    9) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" "$args6" "$args7" "$args8" ;;
  esac
fi

FILE="$0"

while [ -h "$FILE" ]; do
  permission=$(ls -ld "$FILE")
  path=$(expr "$permission" : ".*-> \(.*\)$")

  if expr "$path" : "/.*" > "/dev/null"; then
    FILE=$path
  else
    directory=$(dirname "$FILE")
    FILE=$directory"/"$path
  fi
done

GRADLE=$(pwd)
DIRECTORY=$(dirname "$FILE")

cd "$DIRECTORY" > "/dev/null" || exit
HOME=$(pwd -P)

cd "$GRADLE" > "/dev/null" || exit
WRAPPER="$HOME/gradle/wrapper/gradle-wrapper.jar"

if [ -n "$JAVA" ]; then
  if [ -x "$JAVA/jre/sh/java" ]; then
    COMMAND="$JAVA/jre/sh/java"
  else
    COMMAND="$JAVA/bin/java"
  fi

  if [ ! -x "$COMMAND" ]; then
    die "ERROR: JAVA is set to an invalid directory: $JAVA Please set the JAVA variable in your
    environment to match the location of your Java installation."
  fi
else
  COMMAND="java"

  which java > "/dev/null" 2>&1 || die "ERROR: JAVA is not set and no \"java\" command could be
  found in your PATH. Please set the JAVA variable in your environment to match the location
  of your Java  installation."
fi

eval set -- "$JVM_OPTS" "$GRADLE_OPTS" "\"-Dorg.gradle.appname=$BASE\"" -classpath "\"$WRAPPER\"" org.gradle.wrapper.GradleWrapperMain "$@"
exec "$COMMAND" "$@"
