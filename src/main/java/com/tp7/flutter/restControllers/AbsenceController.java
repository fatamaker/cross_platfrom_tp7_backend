package com.tp7.flutter.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp7.flutter.entities.Absence;
import com.tp7.flutter.entities.AbsenceId;
import com.tp7.flutter.repos.AbsenceRepository;

@RestController
@RequestMapping("/api/absences")
@CrossOrigin(origins = "*")
public class AbsenceController {
    @Autowired
    private AbsenceRepository absenceRepo;

    @GetMapping
    public List<Absence> getAll() {
        return absenceRepo.findAll();
    }

    @PostMapping("/add")
    public Absence insert(@RequestBody Absence a) {
        return absenceRepo.save(a);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody AbsenceId id) {
        absenceRepo.deleteById(id);
    }
}
