package com.suy.reflection;

import org.junit.Test;

import java.lang.annotation.ElementType;

public class ReflectionTest {
    static {
        System.out.println("ReflectionTest");
    }
    @Test
    public void testClass() {
        var c1 = Object.class;
        var c2 = Comparable.class;
        var c3 = String[].class;
        var c4 = int[].class;
        var c5 = Override.class;
        var c6 = ElementType.class;
        var c7 = Integer.class;
        var c8 = void.class;
        var c9 = Class.class;
        var c10 = float.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println(c10);
    }
}
