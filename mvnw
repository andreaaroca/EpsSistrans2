#!/usr/bin/env sh
# ----------------------------------------------------------------------------
# Maven Wrapper script. Downloads Maven if necessary.
# ----------------------------------------------------------------------------
BASE_DIR="$(cd "$(dirname "$0")" && pwd)"
MVNW_REPO_URL="https://repo.maven.apache.org/maven2"
WRAPPER_DIR="$BASE_DIR/.mvn/wrapper"
JAR="$WRAPPER_DIR/maven-wrapper.jar"
if [ ! -f "$JAR" ]; then
  echo "Downloading Maven Wrapper JAR..."
  mkdir -p "$WRAPPER_DIR"
  curl -s -o "$JAR" "$MVNW_REPO_URL/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar"
fi
java -jar "$JAR" "$@"
