package com.gameof3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gameof3.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game getGameById(Long id);

}
