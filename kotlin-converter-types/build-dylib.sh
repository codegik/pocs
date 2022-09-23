#!/bin/sh

CONVERTER_DIR="src/main/kotlin/com/codegik/poc/converter"
NATIVE_DIR="${CONVERTER_DIR}/nativelib"
DYLIB="libnative.dylib"

#mvn clean install -DskipTests
javac -h $NATIVE_DIR ${CONVERTER_DIR}/JniConverter.java
cd $NATIVE_DIR
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin com_codegik_poc_converter_JniConverter.cpp -o com_codegik_poc_converter_JniConverter.o
g++ -dynamiclib -o $DYLIB com_codegik_poc_converter_JniConverter.o -lc

cd -

mv ${NATIVE_DIR}/${DYLIB} src/main/resources/
rm ${NATIVE_DIR}/*.o
rm ${CONVERTER_DIR}/JniConverter.class

chmod 600 $DYLIB
