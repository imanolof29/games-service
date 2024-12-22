package com.imanolortiz.games_service.games_service.repository;

import com.imanolortiz.games_service.games_service.commons.entities.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {
}
