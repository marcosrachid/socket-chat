package com.websocket.chat.websocket;

import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class ChatWebSocketHandler extends WebSocketHandler {

	@Override
	public void configure(WebSocketServletFactory factory) {
		factory.register(ChatWebSocket.class);
	}

}
