#include <iostream>
#include "com_codegik_poc_converter_JniConverter.h"

JNIEXPORT jstring JNICALL Java_com_codegik_poc_converter_JniConverter_sayHello
  (JNIEnv* env, jobject obj) {
    return env->NewStringUTF("hey guys!");
}


JNIEXPORT jstring JNICALL Java_com_codegik_poc_converter_JniConverter_convertType
  (JNIEnv* env, jobject obj, jobject from) {
    jclass klass = env->GetObjectClass(from);
    jmethodID method = env->GetMethodID(klass, "getName", "()Ljava/lang/String;");
    jstring name = (jstring)env->CallObjectMethod(from, method);

    return name;
}