package com.socket.chat.nickname;

import com.socket.chat.nickname.exception.NicknameException;

public class Nickname {

	private static Nickname instance = null;

	private static String nickname = null;

	public static Nickname getInstance() {
		if (instance == null) {
			instance = new Nickname();
		}
		return instance;
	}

	public Nickname withNickName(String nickname) {
		Nickname.nickname = nickname;
		return this;
	}

	public String getNickname() throws NicknameException {
		if (nickname == null) {
			throw new NicknameException("Nickname is not set, please try again.");
		}
		return nickname;
	}

}
