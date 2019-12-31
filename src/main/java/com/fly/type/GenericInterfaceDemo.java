package com.fly.type;

import java.lang.reflect.Type;

/**
 * @author zhishui
 * @date 2019/12/31
 * @time 3:54 PM
 */
public class GenericInterfaceDemo implements A<GenericInterfaceDemo>, B {

    public static void main(String[] args) {

        Class<?>[] interfaces = GenericInterfaceDemo.class.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i);
        }

        System.out.println("=====================================");

        Type[] genericInterfaces = GenericInterfaceDemo.class.getGenericInterfaces();
        for (Type type : genericInterfaces) {
            System.out.println(type);
        }

    }
}


interface A<T> {}
interface B {}
interface C extends A {}
