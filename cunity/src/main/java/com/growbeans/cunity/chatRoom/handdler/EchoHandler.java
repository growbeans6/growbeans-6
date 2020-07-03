package com.growbeans.cunity.chatRoom.handdler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	//세션 리스트
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

    private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
   
    @Override
    @Async 
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	// 웹소켓세션에 접속
        
        
    }

    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    @Async
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        
    }
    //클라이언트 연결을 끊었을 때 실행
    @Override
    @Async
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	
       
    }
}
