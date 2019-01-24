package com.nncq.sunmoon.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SpringWebSocketHandler extends TextWebSocketHandler {
	public static Map<String, WebSocketSession> online = new HashMap<String, WebSocketSession>();

	public SpringWebSocketHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 连接成功时候，会触发页面上onopen方法
	 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		online.put(session.getAttributes().get("WEBSOCKET_USERNAME").toString(), session);
	}

	/**
	 * 关闭连接时触发
	 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		String username = (String) session.getAttributes().get("WEBSOCKET_USERNAME");
		online.remove(username);
	}

	/**
	 * js调用websocket.send时候，会调用该方法
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
	}

	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给某个用户发送消息
	 *
	 * @param userName
	 * @param message
	 */
	public void sendMessageToUser(String userName, TextMessage message) {
		for (Entry<String, WebSocketSession> entry : online.entrySet()) {
			if (entry.getKey().equals(userName)) {
				try {
					if (entry.getValue().isOpen()) {
						entry.getValue().sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}

		}
	
	}

	/**
	 * 给所有在线用户发送消息
	 *
	 * @param message
	 */
	public void sendMessageToUsers(TextMessage message) {
		for (Entry<String, WebSocketSession> entry : online.entrySet()) {
			try {
				if (entry.getValue().isOpen()) {
					entry.getValue().sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		}
	}

}