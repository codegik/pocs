#include <iostream>
#include "com_codegik_poc_converter_JniConverter.h"

JNIEXPORT jstring JNICALL Java_com_codegik_poc_converter_JniConverter_sayHello
  (JNIEnv* env, jobject thisObject) {
    std::string hello = "Hello world!";
    return env->NewStringUTF(hello.c_str());
}