package com.fly.test;

import com.google.inject.TypeLiteral;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.Map;

/**
 * @author zhishui
 * @date 2019/12/31
 * @time 3:04 PM
 */
public class MyTest {

    @Test
    public void myTestMap() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Type mapK = Map.class.getTypeParameters()[0];
        System.out.println(mapK instanceof TypeVariable);
        if (mapK instanceof TypeVariable) {
            TypeVariable typeK = (TypeVariable) mapK;
            GenericDeclaration genericDeclaration = typeK.getGenericDeclaration();
            System.out.println(genericDeclaration);
        }


        TypeLiteral<?> typeResolver = TypeLiteral.get(StringIntegerMap.class);

        Method resolveType = TypeLiteral.class.getDeclaredMethod("resolveType", Type.class);
        if (!resolveType.isAccessible()) {
            resolveType.setAccessible(true);
        }
        Object invoke = resolveType.invoke(typeResolver, mapK);

        System.out.println(invoke);


        typeResolver = new TypeLiteral<BestMap<String, Integer>>() {};
        invoke = resolveType.invoke(typeResolver, mapK);
        System.out.println(invoke);
    }

    interface StringIntegerMap extends Map<String, Integer> {}

    interface BetterMap<K1, V1> extends Map<K1, V1> {}

    interface BestMap<K2, V2> extends BetterMap<K2, V2> {}



}
