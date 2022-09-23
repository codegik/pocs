#!/bin/sh

javac -h . JniConverter.java
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin com_codegik_poc_converter_JniConverter.cpp -o com_codegik_poc_converter_JniConverter.o
g++ -dynamiclib -o libnative.dylib com_codegik_poc_converter_JniConverter.o -lc
chmod 600 libnative.dylib
