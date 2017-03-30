#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_eoe_drugstore_fragment_HomeFragment_getMsgFromJni(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, "Hello Jni");
}