package com.imanolortiz.games_service.games_service.controller;

import com.imanolortiz.games_service.games_service.commons.constants.ApiPathConstants;
import com.imanolortiz.games_service.games_service.commons.dtos.CreateGameDto;
import com.imanolortiz.games_service.games_service.commons.dtos.GameDto;
import com.imanolortiz.games_service.games_service.commons.dtos.UpdateGameDto;
import com.imanolortiz.games_service.games_service.commons.entities.GameModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.GAME_ROUTE)
public interface GameApi {

    @GetMapping(value = "")
    ResponseEntity<List<GameDto>> listGames();

    @PostMapping(value = "create")
    ResponseEntity<GameDto> createGame(@RequestBody CreateGameDto dto);

    @GetMapping(value = "/{gameId}")
    ResponseEntity<GameDto> getGame(@PathVariable Long gameId);

    @DeleteMapping(value = "/{gameId}")
    ResponseEntity<Void> deleteGame(@PathVariable Long gameId);

    @PutMapping(value = "/{gameId}")
    ResponseEntity<Void> updateGame(@PathVariable Long gameId, @RequestBody UpdateGameDto dto);

}
