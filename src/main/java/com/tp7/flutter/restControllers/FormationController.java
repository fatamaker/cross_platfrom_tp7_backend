package com.tp7.flutter.restControllers;

import com.tp7.flutter.entities.Formation;
import com.tp7.flutter.repos.FormationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formations")
@CrossOrigin(origins = "*")
public class FormationController {
	@Autowired
    private FormationRepository repo;

    @GetMapping
    public List<Formation> all() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public Formation add(@RequestBody Formation f) {
        return repo.save(f);
    }

}
