package com.socket.chat.client;

import static com.socket.chat.util.PrinterUtil.printLine;
import static com.socket.chat.util.constants.NetworkConstants.INET_ADDR;
import static com.socket.chat.util.constants.NetworkConstants.PORT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {
	
	private static Thread thread;

	public static void start() {
		Runnable runnable = () -> {
			try (MulticastSocket clientSocket = new MulticastSocket(PORT)) {
				InetAddress address = InetAddress.getByName(INET_ADDR);
				byte[] buf = new byte[256];
				clientSocket.joinGroup(address);
				while (true) {
					DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
					clientSocket.receive(msgPacket);
					String msg = new String(buf, 0, buf.length);
					printLine(msg);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		};

		thread = new Thread(runnable);
		thread.start();
	}
	
	public static void end() {
		thread.interrupt();
	}

}
