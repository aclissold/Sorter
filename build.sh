#!/bin/bash


if [[ ! -d lib ]]
then
    # Download dependencies
    echo "Downloading dependencies..."
    mkdir -p lib
    cd lib
    curl -O "http://search.maven.org/remotecontent?filepath=junit/junit/4.11/junit-4.11.jar"
    curl -O "http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar"
    cd ..
fi

# Ensure binary directory exists
mkdir -p bin

# Compile main classes
javac -d bin src/main/com/andrewclissold/sorter/Sorter.java

# Compile test classes
javac -d bin \
    -sourcepath src/main \
    -classpath lib/junit-4.11.jar:lib/hamcrest-core-1.3.jar \
    src/test/com/andrewclissold/sorter/SorterTest.java
