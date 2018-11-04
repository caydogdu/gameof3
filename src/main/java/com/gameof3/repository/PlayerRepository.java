package com.gameof3.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gameof3.entity.Player;

@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT o FROM Player AS o WHERE o.gameId = :gameId")
    List<Player> getByGameId(@Param("gameId") Long gameId);

    Player getPlayerById(Long id);

}
