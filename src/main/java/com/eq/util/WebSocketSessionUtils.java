/**
 * 
 */
package com.eq.util;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author mega
 *
 */
public class WebSocketSessionUtils
{
	private static List<WebSocketSession> sessionList = Lists.newArrayList();
	public static void addSession(WebSocketSession session) {
		WebSocketSession session2 = contaions(session);
		if(session2 == null) {
			sessionList.add(session);
		}
	}
	public static void removeSession(WebSocketSession session) {
		WebSocketSession session2 = contaions(session);
		if(session2 != null) {
			sessionList.remove(session2);
		}
	}
	public static List<WebSocketSession> getSessionByKey(String key) {
		List<WebSocketSession> list = Lists.newArrayList();
		for(WebSocketSession wsSession:sessionList) {
			if(wsSession.getKey().equals(key)) {
				list.add(wsSession);
			}
		}
		return list;
	}
	public static WebSocketSession contaions(WebSocketSession session) {
		for(WebSocketSession wsSession:sessionList) {
			if(wsSession.getKey().equals(session.getKey())&&wsSession.getSession().equals(session.getSession())) {
				return wsSession;
			}
		}
		return null;
	}
}
