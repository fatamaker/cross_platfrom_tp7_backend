package com.tp7.flutter.restControllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.tp7.flutter.entities.Etudiant;
import com.tp7.flutter.repos.EtudiantRepository;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
@CrossOrigin(origins = "*")
public class EtudiantController {
    @Autowired
    private EtudiantRepository repo;

    @GetMapping
    public List<Etudiant> all() {
        return repo.findAll();
    }

    @GetMapping("/classe/{id}")
    public List<Etudiant> byClasse(@PathVariable Integer id) {
        return repo.findAll().stream()
                .filter(e -> e.getClasse().getId().equals(id))
                .toList();
    }

    @PostMapping
    public Etudiant add(@RequestBody Etudiant e) {
        return repo.save(e);
    }
}
