package com.tp7.flutter.restControllers;



import com.tp7.flutter.entities.ClassMat;
import com.tp7.flutter.entities.ClassMatId;
import com.tp7.flutter.repos.ClassMatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classmat")
@RequiredArgsConstructor
public class ClassMatController {

    private final ClassMatRepository repository;

    // ➤ Ajouter un enregistrement ClassMat
    @PostMapping
    public ClassMat create(@RequestBody ClassMat classMat) {
        return repository.save(classMat);
    }

    // ➤ Afficher tout
    @GetMapping
    public List<ClassMat> getAll() {
        return repository.findAll();
    }

    // ➤ Récupérer par clé composite
    @GetMapping("/{codMat}/{codClass}")
    public ClassMat getOne(@PathVariable String codMat, @PathVariable String codClass) {
        ClassMatId id = new ClassMatId(codMat, codClass);
        return repository.findById(id).orElse(null);
    }

    // ➤ Supprimer
    @DeleteMapping("/{codMat}/{codClass}")
    public void delete(@PathVariable String codMat, @PathVariable String codClass) {
        ClassMatId id = new ClassMatId(codMat, codClass);
        repository.deleteById(id);
    }

    // ➤ Mettre à jour
    @PutMapping("/{codMat}/{codClass}")
    public ClassMat update(
            @PathVariable String codMat,
            @PathVariable String codClass,
            @RequestBody ClassMat updated
    ) {
        ClassMatId id = new ClassMatId(codMat, codClass);

        return repository.findById(id)
                .map(existing -> {
                    existing.setCoef(updated.getCoef());
                    existing.setChsm(updated.getChsm());
                    existing.setMatiere(updated.getMatiere());
                    existing.setClasse(updated.getClasse());
                    return repository.save(existing);
                })
                .orElse(null);
    }
}
