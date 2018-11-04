package com.gameof3.service;

import com.gameof3.dto.RequestDto;
import com.gameof3.dto.MessageDto;
import com.gameof3.entity.Game;

public interface GameService {

    Game getAvailableGame();

    MessageDto join(RequestDto request);

    MessageDto play(RequestDto request);

    MessageDto start(RequestDto request);

}
