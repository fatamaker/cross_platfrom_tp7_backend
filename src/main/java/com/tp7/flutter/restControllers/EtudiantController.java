package com.tp7.flutter.restControllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.tp7.flutter.entities.Etudiant;
import com.tp7.flutter.entities.Classe;
import com.tp7.flutter.repos.EtudiantRepository;
import com.tp7.flutter.repos.ClasseRepository;

@RestController
@RequestMapping("/api/etudiants")
@CrossOrigin(origins = "*")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepo;

    @Autowired
    private ClasseRepository classeRepo;

    // Récupérer tous les étudiants
    @GetMapping
    public List<Etudiant> all() {
        return etudiantRepo.findAll();
    }

    // Récupérer les étudiants d’une classe spécifique
    @GetMapping("/classe/{id}")
    public List<Etudiant> byClasse(@PathVariable Integer id) {
        return etudiantRepo.findByClasse_Id(id);
    }

    // Ajouter un étudiant
    @PostMapping
    public Etudiant add(@RequestBody Etudiant e) {
        if (e.getClasse() != null) {
            Classe c = classeRepo.findById(e.getClasse().getId())
                    .orElseThrow(() -> new RuntimeException("Classe non trouvée"));
            e.setClasse(c);
        }
        return etudiantRepo.save(e);
    }
}
