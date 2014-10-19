package com.server.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@javax.websocket.server.ServerEndpoint(value="/game")
public class ServerEndPoint {
	
	   private static Set<Session> list = Collections.synchronizedSet(new HashSet<Session>());
	   
	   @OnOpen
	   public void onOpen(Session session) throws IOException{
		   System.out.println(session.getId() + " : connected ... ");
		   session.getBasicRemote().sendText("Session id "+session.getId());
		   list.add(session);
	   }
	   
	   @OnClose
	   public void onClose(Session session, CloseReason closeReason) {
		   System.out.printf("Session %s closed because of %s", session.getId(), closeReason.getReasonPhrase());
		   list.remove(session);
	   }
	   
	   @OnMessage
	   public void onMessage(Session session,String msg) throws IOException,SQLException{
		 
	   } 
}
