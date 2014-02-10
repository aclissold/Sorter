#!/bin/bash

set -e

if [[ ! -d lib ]]
then
    # Download dependencies
    echo "Downloading dependencies..."
    curl -O "http://search.maven.org/remotecontent?filepath=junit/junit/4.11/junit-4.11.jar"
    curl -O "http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar"
    mkdir -p lib
    mv ./*.jar lib
fi

# Ensure binary directory exists
mkdir -p bin

# Compile everything
javac -d bin \
    -sourcepath src/main \
    -classpath lib/junit-4.11.jar:lib/hamcrest-core-1.3.jar \
    src/test/com/andrewclissold/sorter/SorterTest.java
