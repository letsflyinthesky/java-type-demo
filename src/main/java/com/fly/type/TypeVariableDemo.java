package com.fly.type;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @author zhishui
 * @date 2019/12/31
 * @time 12:11 PM
 */
public class TypeVariableDemo<K extends Comparable & Serializable, V> {
    K key;
    V value;

    public static void main(String[] args) throws NoSuchFieldException {
        Field fk = TypeVariableDemo.class.getDeclaredField("key");
        Field fv = TypeVariableDemo.class.getDeclaredField("value");
        System.out.println(fk.getGenericType());
        System.out.println(fv.getGenericType());

        System.out.println(fk.getGenericType() instanceof TypeVariable);
        System.out.println(fv.getGenericType() instanceof TypeVariable);

        TypeVariable keyType = (TypeVariable) fk.getGenericType();
        TypeVariable valueType = (TypeVariable) fv.getGenericType();

        System.out.println(keyType.getName());
        System.out.println(valueType.getName());


        System.out.println(keyType.getGenericDeclaration());
        System.out.println(keyType.getGenericDeclaration() instanceof Class);
        if (keyType.getGenericDeclaration() instanceof Class) {
            System.out.println((Class) keyType.getGenericDeclaration());
        }
        System.out.println(valueType.getGenericDeclaration());
        System.out.println(valueType.getGenericDeclaration() instanceof Class);
        if (valueType.getGenericDeclaration() instanceof Class) {
            System.out.println((Class) valueType.getGenericDeclaration());
        }

        System.out.println("k的上界");
        for (Type type : keyType.getBounds()) {
            System.out.println(type);
        }


        System.out.println("v的上界");
        for (Type type : valueType.getBounds()) {
            System.out.println(type);
        }
    }

}
