package com.tp7.flutter.restControllers;


import org.springframework.web.bind.annotation.*;

import com.tp7.flutter.entities.Departement;
import com.tp7.flutter.repos.DepartementRepository;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
@CrossOrigin("*")
public class DepartementController {

    private final DepartementRepository repo;

    public DepartementController(DepartementRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Departement> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Departement create(@RequestBody Departement d) {
        return repo.save(d);
    }

    @GetMapping("/{id}")
    public Departement getOne(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }
}
