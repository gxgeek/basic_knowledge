package com.gxgeek.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class InetAddressExample {

    public static void main(String[] args) {
        try {

            Enumeration<NetworkInterface> interfaceList =

                    NetworkInterface.getNetworkInterfaces();

            if (interfaceList == null) {

                System.out.println("--No interfaces found--");

            } else {

                while (interfaceList.hasMoreElements()) {

                    NetworkInterface iface =

                            interfaceList.nextElement();

                    System.out.println("Interface " + iface.getName()

                            + ":");

                    Enumeration<InetAddress> addrList =

                            iface.getInetAddresses();
                    System.out.println(addrList);
                }

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
