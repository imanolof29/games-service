package com.imanolortiz.games_service.games_service.service;

import com.imanolortiz.games_service.games_service.commons.dtos.CreateGameDto;
import com.imanolortiz.games_service.games_service.commons.dtos.GameDto;
import com.imanolortiz.games_service.games_service.commons.dtos.UpdateGameDto;

import java.util.List;

public interface GameService {
    List<GameDto> getAllGames();
    GameDto createGame(CreateGameDto dto);
    GameDto getGame(Long gameId);
    void deleteGame(Long id);
    void updateGame(Long id, UpdateGameDto dto);
}
