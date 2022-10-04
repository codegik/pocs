#!/bin/sh

CONVERTER_DIR="src/main/kotlin/com/codegik/poc/converter"
NATIVE_DIR="${CONVERTER_DIR}/nativelib"
DYLIB="libnative.dylib"
JVM_LIB_DIR="$HOME/Library/Java/Extensions"

mvn clean install -DskipTests
javac -h $NATIVE_DIR ${CONVERTER_DIR}/JniConverter.java
cd $NATIVE_DIR
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin com_codegik_poc_converter_JniConverter.cpp -o com_codegik_poc_converter_JniConverter.o
g++ -dynamiclib -o $DYLIB com_codegik_poc_converter_JniConverter.o -lc

cd -

mkdir -p ${JVM_LIB_DIR}
cp ${NATIVE_DIR}/${DYLIB} ${JVM_LIB_DIR}/
rm ${NATIVE_DIR}/${DYLIB}
rm ${NATIVE_DIR}/*.o
rm ${CONVERTER_DIR}/JniConverter.class

chmod 600 ${JVM_LIB_DIR}/${DYLIB}

echo "Library installed on $JVM_LIB_DIR/$DYLIB"
echo "Execute the command to test JNI converter:"
echo "  mvn test -Dtest=\"JniConverterTest\""