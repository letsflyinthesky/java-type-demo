package com.fly.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author zhishui
 * @date 2019/12/31
 * @time 12:05 PM
 */
public class ParameterizedDemo {

    private Map<String, String> map;
    Map<List<String>, String> map2;
    public static void main(String[] args) throws NoSuchFieldException {
        Field map = ParameterizedDemo.class.getDeclaredField("map");
        if (!map.isAccessible()) {
            map.setAccessible(true);
        }
        System.out.println(map.getGenericType());
        System.out.println(map.getGenericType() instanceof ParameterizedType);
        ParameterizedType pType = (ParameterizedType)map.getGenericType();
        System.out.println(pType.getRawType());
        for (Type type : pType.getActualTypeArguments()) {
            System.out.println(type);
        }
        System.out.println(pType.getOwnerType());
    }
}
