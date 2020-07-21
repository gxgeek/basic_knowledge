package com.gxgeek.network.char04;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class TcpEchoServer {
	private static int buffer = 64;

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		if (args.length != 1) {
			throw new IllegalArgumentException();
		}
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
		int temp = 0;
		byte[] data = new byte[buffer];
		while (true) {
			Socket socket = serverSocket.accept();
			// SocketAddress socketAddress = socket.getRemoteSocketAddress();
			// System.out.println("handle client at " + socketAddress);
			System.out.println("handle socket:" + socket + " start");
			TimeUnit.SECONDS.sleep(10);//
			System.out.println("handle socket:" + socket + " end");
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			while ((temp = in.read(data)) != -1) {
				out.write(data, 0, temp);
			}
			socket.close();
		}

	}
}
