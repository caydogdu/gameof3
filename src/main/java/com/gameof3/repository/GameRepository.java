package com.gameof3.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gameof3.entity.Game;

@Transactional
public interface GameRepository extends JpaRepository<Game, Long> {

    Game getGameById(Long id);

}
