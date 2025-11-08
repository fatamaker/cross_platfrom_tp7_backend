package com.tp7.flutter.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp7.flutter.entities.Classe;
import com.tp7.flutter.repos.ClasseRepository;

@RestController
@RequestMapping("/classes")
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
