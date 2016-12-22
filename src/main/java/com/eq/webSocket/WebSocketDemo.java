/**
 * 
 */
package com.eq.webSocket;

import java.io.IOException;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.shiro.SecurityUtils;

import com.eq.util.ShiroUtils;
import com.eq.util.WebSocketSession;
import com.eq.util.WebSocketSessionUtils;

/**
 * @author mega
 *
 */
@ServerEndpoint("/websocket")
public class WebSocketDemo
{
	public static String s = "";
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException
	{
		// Print the client message for testing purposes
		System.out.println("Received: " + message);
		String id = session.getId();
		
	}

	@OnOpen
	public void onOpen(Session session)
	{
		WebSocketSession session2 = new WebSocketSession();
		session2.setKey("websocket:"+ShiroUtils.getUser().getId());
		session2.setSession(session);
		WebSocketSessionUtils.addSession(session2);
	}

	@OnClose
	public void onClose(Session session)
	{
		WebSocketSession session2 = new WebSocketSession();
		session2.setKey("websocket:"+ShiroUtils.getUser().getId());
		session2.setSession(session);
		WebSocketSessionUtils.removeSession(session2);
	}
}
