package com.gxgeek.network.char04;

import com.gxgeek.network.char03.VoteMsg;
import com.gxgeek.network.char03.VoteMsgCoder;
import com.gxgeek.network.char03.VoteMsgTextCoder;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class VoteMulticastSender {
	private static String multiAddress = "239.255.255.254";// 多播的地址
	private static int port = 13133;// 设置端口
	private static int ttl = 1;// 设置跳数

	public static void main(String[] args) throws Exception {
		InetAddress inetAddress = InetAddress.getByName(multiAddress);
		if (!inetAddress.isMulticastAddress()) {
			throw new Exception("这不是一个多播地址");
		}
		MulticastSocket socket = new MulticastSocket();
		socket.setTimeToLive(ttl);
		VoteMsgCoder coder = new VoteMsgTextCoder();
		VoteMsg msg = new VoteMsg(true, false, 888, 0);
		byte[] enCodeMsg = coder.toWire(msg);
		DatagramPacket packet = new DatagramPacket(enCodeMsg, enCodeMsg.length, inetAddress, port);
		socket.send(packet);
		socket.close();
	}
}
