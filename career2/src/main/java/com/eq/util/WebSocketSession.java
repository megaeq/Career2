/**
 * 
 */
package com.eq.util;

import javax.websocket.Session;

/**
 * @author mega
 *
 */
public class WebSocketSession
{
	private Session session;
	private String key;
	public Session getSession()
	{
		return session;
	}
	public void setSession(Session session)
	{
		this.session = session;
	}
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	
}
