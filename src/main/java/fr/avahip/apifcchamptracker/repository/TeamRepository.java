package fr.avahip.apifcchamptracker.repository;

import fr.avahip.apifcchamptracker.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByUser_Email(String email);
}
