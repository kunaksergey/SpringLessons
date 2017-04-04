package ua.shield.controller;
/**
 * Created by sa on 30.03.17.
 */

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        session.sendMessage(new TextMessage(textMessage.getPayload()));
    }
}