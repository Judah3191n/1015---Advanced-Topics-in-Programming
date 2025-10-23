package com.example.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Students.Model.Alien;
import com.example.Students.repo.AlienRepo;

import java.util.List;

@RestController
@RequestMapping("/aliens")
public class AlienController {

    @Autowired
    private AlienRepo repo;

    // GET all aliens
    @GetMapping
    public List<Alien> getAllAliens() {
        return repo.findAll();
    }

    // GET one alien by ID
    @GetMapping("/{id}")
    public Alien getAlienById(@PathVariable int id) {
        return repo.findById(id);
    }

    // POST new alien
    @PostMapping
    public String createAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return "Alien created!";
    }

    // PUT update alien
    @PutMapping("/{id}")
    public String updateAlien(@PathVariable int id, @RequestBody Alien alien) {
        alien.setId(id);
        repo.update(alien);
        return "Alien updated!";
    }

    // DELETE alien
    @DeleteMapping("/{id}")
    public String deleteAlien(@PathVariable int id) {
        repo.deleteById(id);
        return "Alien deleted!";
    }
}
