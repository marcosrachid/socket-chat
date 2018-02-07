package com.websocket.chat;

import static com.websocket.chat.util.PrinterUtil.print;
import static com.websocket.chat.util.PrinterUtil.printLine;

import java.util.Scanner;

import org.eclipse.jetty.server.Server;

import com.websocket.chat.nickname.Nickname;
import com.websocket.chat.websocket.ChatWebSocketHandler;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			Server server = new Server(8080);
			ChatWebSocketHandler wsHandler = new ChatWebSocketHandler();
			server.setHandler(wsHandler);
			server.start();
			server.join();
			banner();
			name();

		} catch (Exception e) {
			e.printStackTrace();
		}
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
		Scanner scanIn = new Scanner(System.in);
		nickname.withNickName(scanIn.nextLine());
		scanIn.close();
	}
}
