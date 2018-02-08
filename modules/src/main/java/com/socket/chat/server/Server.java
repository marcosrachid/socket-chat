package com.socket.chat.server;

import static com.socket.chat.util.constants.NetworkConstants.INET_ADDR;
import static com.socket.chat.util.constants.NetworkConstants.PORT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.socket.chat.nickname.Nickname;
import com.socket.chat.nickname.exception.NicknameException;

public class Server extends DatagramSocket {

	private static Server instance = null;

	private Server() throws SocketException {
		super();
	}

	public static void isOnline() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String msg;
			try {
				msg = String.format("[%s] is online.", Nickname.getInstance().getNickname());
				send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public static void exit() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String msg;
			try {
				msg = String.format("[%s] quit from room.", Nickname.getInstance().getNickname());
				send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static void sendMessage(String message) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			try {
				String msg = String.format("[%s]: %s", Nickname.getInstance().getNickname(), message);
				send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private static void send(String fullMessage) throws NicknameException, IOException, InterruptedException {
		if (instance == null) {
			instance = new Server();
		}
		InetAddress addr = InetAddress.getByName(INET_ADDR);
		DatagramPacket msgPacket = new DatagramPacket(fullMessage.getBytes(), fullMessage.getBytes().length, addr,
				PORT);
		instance.send(msgPacket);
		Thread.sleep(500);
	}

}
