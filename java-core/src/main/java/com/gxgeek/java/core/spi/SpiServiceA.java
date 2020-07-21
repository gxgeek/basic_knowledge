package com.gxgeek.java.core.spi;


public class SpiServiceA implements SpiService {

    @Override
    public void hello() {
        System.out.println("SpiServiceA.Hello");
    }

}
