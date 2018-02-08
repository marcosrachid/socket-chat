package com.socket.chat;

import static com.socket.chat.util.PrinterUtil.print;
import static com.socket.chat.util.PrinterUtil.printLine;

import java.io.IOException;
import java.util.Scanner;

import com.socket.chat.client.Client;
import com.socket.chat.nickname.Nickname;
import com.socket.chat.nickname.exception.NicknameException;
import com.socket.chat.server.Server;

public class App {

	private static Scanner scanner;

	public static void main(String[] args) throws NicknameException, IOException, InterruptedException {
		/** Start up **/
		scanner = new Scanner(System.in);

		startClient();
		banner();
		name();
		startServer();
	}

	private static void banner() {
		printLine("'||''|.                   '||       ||       '||       ..|'''.| '||                .   ");
		printLine(" ||   ||   ....     ....   || ..   ...     .. ||     .|'     '   || ..    ....   .||.  ");
		printLine(" ||''|'   '' .||  .|   ''  ||' ||   ||   .'  '||     ||          ||' ||  '' .||   ||   ");
		printLine(" ||   |.  .|' ||  ||       ||  ||   ||   |.   ||     '|.      .  ||  ||  .|' ||   ||   ");
		printLine(".||.  '|' '|..'|'  '|...' .||. ||. .||.  '|..'||.     ''|....'  .||. ||. '|..'|'  '|.' ");
		printLine("");
		printLine("");
	}

	private static void name() {
		Nickname nickname = Nickname.getInstance();
		print("What's your name ? ");
		nickname.withNickName(scanner.nextLine());
		Server.isOnline();
	}

	private static void startClient() {
		Client.start();
	}

	private static void startServer() throws IOException, InterruptedException {
		String input = "";

		do {
			Thread.sleep(1000);
			print("Enter something : ");
			input = scanner.nextLine();
			Server.sendMessage(input);
		} while (!"!exit".contains(input));

		Server.exit();
		scanner.close();
		System.exit(0);
	}
}
