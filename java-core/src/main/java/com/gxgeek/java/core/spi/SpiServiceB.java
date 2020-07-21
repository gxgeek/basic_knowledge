package com.gxgeek.java.core.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiServiceB implements SpiService {

    @Override
    public void hello() {
        System.out.println("SpiServiceB.hello");
    }



    public static void main(String[] arg) {
        ServiceLoader<SpiService> serviceLoader = ServiceLoader.load(SpiService.class);

        Iterator<SpiService> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            SpiService spiService = iterator.next();

            spiService.hello();
        }
    }

}
