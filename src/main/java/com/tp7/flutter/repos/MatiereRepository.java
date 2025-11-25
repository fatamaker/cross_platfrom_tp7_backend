package com.tp7.flutter.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tp7.flutter.entities.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Integer> {
	Optional<Matiere> findByCodMat(Integer codMat);
}
