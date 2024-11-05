package fr.avahip.apifcchamptracker.repository;

import fr.avahip.apifcchamptracker.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeam_Id(long id);
}
