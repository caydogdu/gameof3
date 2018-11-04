package com.gameof3.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameof3.dto.MessageDto;
import com.gameof3.dto.RequestDto;
import com.gameof3.entity.Game;
import com.gameof3.entity.Player;
import com.gameof3.repository.GameRepository;
import com.gameof3.repository.PlayerRepository;
import com.gameof3.util.GameMessageSource;
import com.gameof3.util.GameUtil;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameMessageSource messageSource;

    @Override
    public Game getAvailableGame() {
        Game game;
        List<Game> games = gameRepository.findAll();
        if (!games.isEmpty()) {
            game = games.get(games.size() - 1);
            List<Player> players = playerRepository.getByGameId(game.getId());
            if (players.size() < 2) {
                return game;
            } else {
                return openNewGame();
            }
        }
        return openNewGame();
    }

    @Override
    public MessageDto join(RequestDto request) {
        Game game = gameRepository.getGameById(request.getGameId());

        List<Player> players = playerRepository.getByGameId(game.getId());
        Player player = new Player();
        player.setId((long) players.size());
        player.setGameId(game.getId());
        player.setName("Player" + (players.size() + 1));
        playerRepository.save(player);

        MessageDto message = new MessageDto();
        message.setPlayerId(player.getId());
        message.setPlayerName(player.getName());
        message.setContent(messageSource.getKey("MSG-03", player.getName()));

        return message;
    }

    private Game openNewGame() {
        Game game = new Game();
        game.setName("Game" + new Random().nextInt(20));
        return gameRepository.save(game);
    }

    @Override
    public MessageDto play(RequestDto request) {
        Game game = gameRepository.getGameById(request.getGameId());

        if (!game.isGameStarted()) {
            return start(request);
        }

        Player player = playerRepository.getPlayerById((request.getPlayerId()));

        if (game.getTurn() != request.getPlayerId()) {
            Player turnPlayer = playerRepository.getPlayerById(game.getTurn());
            return new MessageDto(messageSource.getKey("MSG-05", turnPlayer.getName()));
        }

        int adjustment = GameUtil.getAdjustment(request.getAdjustment(), game.getNumber());
        boolean divisible = (game.getNumber() + adjustment) % 3 == 0;
        if (!GameUtil.adjustmentArrayContains(adjustment) || !divisible) {
            return new MessageDto(messageSource.getKey("MSG-06"));
        }

        game.setNumber((game.getNumber() + adjustment) / 3);
        game.switchTurn();

        if (game.getNumber() == 1) {
            game.setGameOver(true);
            gameRepository.save(game);
            return new MessageDto(messageSource.getKey("MSG-07", player.getName()));
        }
        gameRepository.save(game);
        return new MessageDto(messageSource.getKey("MSG-08", player.getName(), adjustment, game.getNumber()));

    }

    @Override
    public MessageDto start(RequestDto request) {
        Game game = gameRepository.getGameById(request.getGameId());
        Player player = playerRepository.getPlayerById(request.getPlayerId());

        List<Player> players = playerRepository.getByGameId(game.getId());
        if (players.size() < 2) {
            return new MessageDto(messageSource.getKey("MSG-01"));
        }

        if (game.isGameStarted()) {
            return new MessageDto(messageSource.getKey("MSG-09"));
        }

        game.setNumber(100 + new Random().nextInt(200));
        game.setTurn(player.getId());
        game.switchTurn();
        game.setGameStarted(true);
        gameRepository.save(game);

        return new MessageDto(messageSource.getKey("MSG-04", player.getName(), game.getNumber()));
    }

}