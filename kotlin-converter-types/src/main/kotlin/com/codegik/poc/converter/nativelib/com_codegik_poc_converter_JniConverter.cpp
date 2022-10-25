#include <iostream>
#include <cstdlib>
#include "com_codegik_poc_converter_JniConverter.h"



jobject newInstance(JNIEnv* env, jclass toClass) {
  jmethodID constructor = env->GetMethodID(toClass, "<init>", "(I)V");
    
  if (constructor == NULL) {
      std::cout << "Can't get constructor for " << toClass; 
      exit(-1);
  }

  return env->NewObject(toClass, constructor);
}


jobjectArray getDeclaredFields(JNIEnv* env, jobject object) {
  jclass klass = env->GetObjectClass(object);
  jmethodID declaredFieldsMethod = env->GetMethodID(klass, "getDeclaredFields", "()[Ljava/lang/reflect/Field;");
  
  if (declaredFieldsMethod == NULL) {
    std::cout << "Can't get MethodID for class.getDeclaredFields()"; 
    exit(-1);
  }

  return (jobjectArray) env->CallObjectMethod(object, declaredFieldsMethod);
}


JNIEXPORT jstring JNICALL Java_com_codegik_poc_converter_JniConverter_sayHello
  (JNIEnv* env, jobject obj) {
    return env->NewStringUTF("hey guys!");
}


JNIEXPORT jstring JNICALL Java_com_codegik_poc_converter_JniConverter_convertType
  (JNIEnv* env, jobject obj, jobject from, jclass toClass) {
    jobjectArray sourceFields = getDeclaredFields(env, from);
    jobject targetObject = newInstance(env, toClass);

    jmethodID getName = env->GetMethodID(toClass, "getName", "()Ljava/lang/String;");
    jstring name = (jstring)env->CallObjectMethod(from, getName);


    return (jstring)env->NewStringUTF8("test");
}

