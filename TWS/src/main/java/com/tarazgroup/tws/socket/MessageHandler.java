package com.tarazgroup.tws.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Aref Azizi
 * @date 11/9/22
 */
//public class MessageHandler  extends TextWebSocketHandler {
//
//        @Override
//        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//
//        }
//
//        @Override
//        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//
//            session.sendMessage(new TextMessage(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY /MM/dd  HH:mm:ss ")) + "You are now connected to the server. This is the first message."));
//        }
//
//        @Override
//        protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
//            // A message has been received
//            System.out.println("Message received: " + textMessage.getPayload());
//        }
//    }

public class MessageHandler extends TextWebSocketHandler {


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // The WebSocket has been closed
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // The WebSocket has been opened
        // I might save this session object so that I can send messages to it outside of this method
            if (LogMessageDto.logMessage != null ){
                session.sendMessage(new TextMessage(  LogMessageDto.logMessage));
        }

        if (LogMessageDto.logMessage == null) {
            session.sendMessage(new TextMessage("null"));
        }
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        // A message has been received
        System.out.println("Message received: " + textMessage.getPayload());
    }
}

