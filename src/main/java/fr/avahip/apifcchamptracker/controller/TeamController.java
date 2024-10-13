package fr.avahip.apifcchamptracker.controller;

import fr.avahip.apifcchamptracker.entity.Team;
import fr.avahip.apifcchamptracker.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @RequestMapping
    public List<Team> findAll() {
        return service.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Team> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Team save(@RequestBody Team team) {
        return service.saveOrUpdate(team);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}