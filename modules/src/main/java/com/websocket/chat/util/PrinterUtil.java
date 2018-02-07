package com.websocket.chat.util;

public class PrinterUtil {

	public static void printLine(String input) {
		System.out.println(input);
	}

	public static void printLine(String input, Object... objects) {
		System.out.println(String.format(input, objects));
	}

	public static void print(String input) {
		System.out.print(input);
	}

	public static void print(String input, Object... objects) {
		System.out.print(String.format(input, objects));
	}

}
