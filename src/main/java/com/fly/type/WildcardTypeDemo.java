package com.fly.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * @author zhishui
 * @date 2019/12/31
 * @time 2:16 PM
 */
public class WildcardTypeDemo {
    private List<? extends Number> upperBound;
    private List<? super Number> lowerBound;

    public static void main(String[] args) throws NoSuchFieldException {
        Field upperBound = WildcardTypeDemo.class.getDeclaredField("upperBound");
        Field lowerBound = WildcardTypeDemo.class.getDeclaredField("lowerBound");

        System.out.println(upperBound.getGenericType() instanceof ParameterizedType);
        System.out.println(lowerBound.getGenericType() instanceof ParameterizedType);


        ParameterizedType upperType = (ParameterizedType) upperBound.getGenericType();
        ParameterizedType lowerType = (ParameterizedType) lowerBound.getGenericType();

        System.out.println(upperType.getActualTypeArguments()[0] instanceof WildcardType);
        System.out.println(lowerType.getActualTypeArguments()[0] instanceof WildcardType);


        WildcardType upperTType = (WildcardType) upperType.getActualTypeArguments()[0];
        WildcardType lowerTType = (WildcardType) lowerType.getActualTypeArguments()[0];


        System.out.println(upperTType.getUpperBounds()[0]);
        System.out.println(lowerTType.getLowerBounds()[0]);

        System.out.println(upperTType);
        System.out.println(lowerTType);
    }

}
