package com.gxgeek.java.core;

import java.lang.reflect.Field;

public class FinalTest {


    public static void main(String[] args) {


        for (int i = 0; i < 100000000L; i++) {
            int f = new A().f();
            if(f != 0 && f!=1){

                System.out.println(f);
            }
        }
    }
}
class A {
    final int x;
    A() {
        x = 1;
    }

    int f() {
        return d(this,this);
    }

    int d(A a1, A a2) {
        int i = a1.x;
        g(a1);
        int j = a2.x;
        return j - i;
    }

    static void g(A a) {
        // 利用反射将 a.x 的值修改为 2
        // uses reflection to change a.x to 2
        Field field = null;
        try {
            field = a.getClass().getDeclaredField("x");
            field.setAccessible(true);
            field.set(a,2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

