package com.gameof3.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gameof3.Application;
import com.gameof3.dto.MessageDto;
import com.gameof3.dto.RequestDto;
import com.gameof3.entity.Game;
import com.gameof3.repository.GameRepository;
import com.gameof3.util.GameMessageSource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class GameServiceImplTest {

    @Mock
    GameMessageSource messagesSource;

    @Autowired
    GameService gameService;

    @Autowired
    GameRepository gameRepository;

    @Test
    public void getAvailableGameTest() throws Exception {

        Game game = gameService.getAvailableGame();
        assertNotNull(game);

    }

    @Test
    public void joinTest() throws Exception {

        RequestDto gr = new RequestDto();
        gr.setGameId(gameService.getAvailableGame().getId());
        MessageDto message = gameService.join(gr);
        assertNotNull(message);

    }

    @Test
    public void playTest() throws Exception {

        Game game = gameService.getAvailableGame();

        RequestDto gr1 = new RequestDto();
        gr1.setGameId(game.getId());
        MessageDto message1 = gameService.join(gr1);
        assertNotNull(message1);

        RequestDto gr2 = new RequestDto();
        gr2.setGameId(game.getId());
        MessageDto message2 = gameService.join(gr2);
        assertNotNull(message2);

        RequestDto gr3 = new RequestDto();
        gr3.setGameId(game.getId());
        gr3.setPlayerId(0);
        MessageDto message3 = gameService.start(gr3);
        assertNotNull(message3);

        RequestDto gr4 = new RequestDto();
        gr4.setGameId(game.getId());
        gr4.setPlayerId(1);
        gr4.setAdjustment(String.valueOf(1));
        MessageDto message4 = gameService.play(gr4);
        assertNotNull(message4);

    }

    @Test
    public void playWrongTurnTest() throws Exception {

        Game game = gameService.getAvailableGame();

        RequestDto gr1 = new RequestDto();
        gr1.setGameId(game.getId());
        MessageDto message1 = gameService.join(gr1);
        assertNotNull(message1);

        RequestDto gr2 = new RequestDto();
        gr2.setGameId(game.getId());
        MessageDto message2 = gameService.join(gr2);
        assertNotNull(message2);

        RequestDto gr3 = new RequestDto();
        gr3.setGameId(game.getId());
        gr3.setPlayerId(0);
        MessageDto message3 = gameService.start(gr3);
        assertNotNull(message3);

        RequestDto gr4 = new RequestDto();
        gr4.setGameId(game.getId());
        gr4.setPlayerId(0);
        gr4.setAdjustment(String.valueOf(1));
        MessageDto message4 = gameService.play(gr4);
        assertNotNull(message4);

    }

    @Test
    public void startTest() throws Exception {

        Game game = gameService.getAvailableGame();

        RequestDto gr1 = new RequestDto();
        gr1.setGameId(game.getId());
        MessageDto message1 = gameService.join(gr1);
        assertNotNull(message1);

        RequestDto gr2 = new RequestDto();
        gr2.setGameId(game.getId());
        MessageDto message2 = gameService.join(gr2);
        assertNotNull(message2);

        RequestDto gr3 = new RequestDto();
        gr3.setGameId(game.getId());
        gr3.setPlayerId(0);
        MessageDto message3 = gameService.start(gr3);
        assertNotNull(message3);

    }

    @Test
    public void startWhenSinglePlayerExistTest() throws Exception {

        Game game = gameService.getAvailableGame();

        RequestDto gr1 = new RequestDto();
        gr1.setGameId(game.getId());
        MessageDto message1 = gameService.join(gr1);
        assertNotNull(message1);

        RequestDto gr3 = new RequestDto();
        gr3.setGameId(game.getId());
        gr3.setPlayerId(0);
        MessageDto message3 = gameService.start(gr3);
        assertNotNull(message3);

    }

}
