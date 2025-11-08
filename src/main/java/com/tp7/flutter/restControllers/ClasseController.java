package com.tp7.flutter.restControllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.tp7.flutter.entities.Classe;
import com.tp7.flutter.repos.ClasseRepository;

@RestController
@RequestMapping("/api/classes")
@CrossOrigin(origins = "*")
public class ClasseController {

    @Autowired
    private ClasseRepository repo;

    @GetMapping
    public List<Classe> all() {
        return repo.findAll();
    }

    @PostMapping
    public Classe add(@RequestBody Classe c) {
        return repo.save(c);
    }
}
