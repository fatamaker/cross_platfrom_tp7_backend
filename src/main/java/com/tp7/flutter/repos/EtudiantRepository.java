package com.tp7.flutter.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tp7.flutter.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {}