package com.tarazgroup.tws.socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {



    //    @Value("${WAN.port}")
    @Value("${voip.port}")
    private String port;

    @Value("${voip.basic}")
    private String ip;

    String concat = "http://"+ip+ port;

    @Bean
    public WebSocketHandler MessageHandler() {
        return new MessageHandler();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(MessageHandler(), "/endpoint").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("http://localhost:3000").setAllowedOrigins("http://localhost:3000/crm/*").setAllowedOrigins("*");
        registry.addHandler(MessageHandler(), "/endpoint").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins(concat).setAllowedOrigins(concat).setAllowedOrigins("*");

    }
}



