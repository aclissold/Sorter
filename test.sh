#!/bin/bash

java -classpath \
    lib/junit-4.11.jar:lib/hamcrest-core-1.3.jar:bin \
    org.junit.runner.JUnitCore com.andrewclissold.sorter.SorterTest
