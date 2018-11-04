package com.gameof3.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gameof3.dto.GameDto;
import com.gameof3.dto.RequestDto;
import com.gameof3.service.GameServiceImpl;

@Controller
public class GameController {

    private static final String TOPIC = "/topic/messages/";

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    public ResponseEntity<GameDto> getGame() {
        return new ResponseEntity<>(gameService.getAvailableGame().asDTO(), HttpStatus.OK);
    }

    @MessageMapping("/join")
    public void join(RequestDto request) {
        messagingTemplate.convertAndSend(TOPIC + request.getGameId(), gameService.join(request));
    }

    @MessageMapping("/play")
    public void play(RequestDto request) {
        messagingTemplate.convertAndSend(TOPIC + request.getGameId(), gameService.play(request));
    }

    @MessageMapping("/start")
    public void start(RequestDto request) {
        messagingTemplate.convertAndSend(TOPIC + request.getGameId(), gameService.start(request));
    }

}
