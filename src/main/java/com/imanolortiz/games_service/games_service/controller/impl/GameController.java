package com.imanolortiz.games_service.games_service.controller.impl;

import com.imanolortiz.games_service.games_service.commons.dtos.CreateGameDto;
import com.imanolortiz.games_service.games_service.commons.dtos.GameDto;
import com.imanolortiz.games_service.games_service.commons.dtos.UpdateGameDto;
import com.imanolortiz.games_service.games_service.commons.entities.GameModel;
import com.imanolortiz.games_service.games_service.controller.GameApi;
import com.imanolortiz.games_service.games_service.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController implements GameApi {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<List<GameDto>> listGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @Override
    public ResponseEntity<GameDto> createGame(CreateGameDto dto) {
        return ResponseEntity.ok(gameService.createGame(dto));
    }

    @Override
    public ResponseEntity<GameDto> getGame(Long gameId) {
        return ResponseEntity.ok(gameService.getGame(gameId));
    }

    @Override
    public ResponseEntity<Void> deleteGame(Long gameId) {
        gameService.deleteGame(gameId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> updateGame(Long gameId, @RequestBody UpdateGameDto dto) {
        gameService.updateGame(gameId, dto);
        return ResponseEntity.noContent().build();
    }
}
