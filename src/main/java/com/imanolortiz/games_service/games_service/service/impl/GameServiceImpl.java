package com.imanolortiz.games_service.games_service.service.impl;

import com.imanolortiz.games_service.games_service.commons.dtos.CreateGameDto;
import com.imanolortiz.games_service.games_service.commons.dtos.GameDto;
import com.imanolortiz.games_service.games_service.commons.dtos.UpdateGameDto;
import com.imanolortiz.games_service.games_service.commons.entities.GameModel;
import com.imanolortiz.games_service.games_service.repository.GameRepository;
import com.imanolortiz.games_service.games_service.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameDto> getAllGames() {
        return gameRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GameDto createGame(CreateGameDto dto) {
        return Optional.of(dto)
                .map(this::mapToEntity)
                .map(gameRepository::save)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Error creating game"));
    }

    @Override
    public GameDto getGame(Long gameId) {
        return Optional.of(gameId)
                .flatMap(gameRepository::findById)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Error retrieving game with id "+gameId));
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public void updateGame(Long gameId, UpdateGameDto dto) {
        gameRepository.findById(gameId)
                .map(existingModel -> {
                    existingModel.setName(dto.getName());
                    return gameRepository.save(existingModel);
                })
                .orElseThrow(() -> new RuntimeException("Error retrieving game with id "+gameId));
    }

    private GameModel mapToEntity(CreateGameDto dto){
        return GameModel.builder()
                .name(dto.getName())
                .build();
    }

    private GameDto mapToDto(GameModel model){
        return GameDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

}
