package fr.avahip.apifcchamptracker.controller;

import fr.avahip.apifcchamptracker.entity.Player;
import fr.avahip.apifcchamptracker.entity.Team;
import fr.avahip.apifcchamptracker.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Player> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Player save(@RequestBody Player player) {
        return service.saveOrUpdate(player);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
