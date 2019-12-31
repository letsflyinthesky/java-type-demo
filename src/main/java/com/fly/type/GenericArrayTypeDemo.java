package com.fly.type;

import sun.jvm.hotspot.utilities.GenericArray;

import java.lang.reflect.*;
import java.util.List;

/**
 * @author zhishui
 * @date 2019/12/31
 * @time 2:08 PM
 */
public class GenericArrayTypeDemo<T> {

    public static void main(String[] args) {
        Method declaredMethod = GenericTypeDemo.class.getDeclaredMethods()[0];
        System.out.println(declaredMethod);

        Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
        for (Type type : genericParameterTypes) {
            System.out.println(type.getTypeName() + "\t" + (type instanceof GenericArrayType));
            if (type instanceof GenericArrayType) {
                System.out.println(((GenericArrayType) type).getGenericComponentType());
                System.out.println(((GenericArrayType) type).getGenericComponentType() instanceof ParameterizedType);
                System.out.println(((GenericArrayType) type).getGenericComponentType() instanceof TypeVariable);
                System.out.println("============================================================");
            }
        }
    }
}

class GenericTypeDemo<T> {
    public void show(List<String>[] pTypeArray, T[] vTypeArray, List<String> list, String[] strings, int[] ints) {
    }
}
