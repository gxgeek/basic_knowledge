package com.gxgeek.network.char05;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpEchoClientTimeout {
	private static int timeOut = 3000;
	private static int times = 5;

	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getByName("127.0.0.1");
		byte[] data = "hello-nonblocking-Udpserver".getBytes();
		int port = 13131;
		DatagramPacket sendPacket = new DatagramPacket(data, data.length, address, port);
		DatagramSocket datagramSocket = new DatagramSocket();
		datagramSocket.setSoTimeout(timeOut);
		DatagramPacket recivePacket = new DatagramPacket(new byte[data.length], data.length);
		int tries = 0;
		boolean receivedResponse = false;
		do {
			datagramSocket.send(sendPacket);
//			System.out.println("client send the packet");
			try {
				datagramSocket.receive(recivePacket);
				if (!recivePacket.getAddress().equals(address)) {
					System.out.println("recive message from a unknow host!");
				}
				receivedResponse = true;
			} catch (InterruptedIOException e) {
				tries++;
				System.out.println("retry " + tries + " time");
			}
		} while (tries < times && !receivedResponse);

		if (receivedResponse) {
			System.out.println("Received:" + new String(recivePacket.getData()));
		} else {
			System.out.println("No response -- give up!");
		}
		datagramSocket.close();
	}
}
