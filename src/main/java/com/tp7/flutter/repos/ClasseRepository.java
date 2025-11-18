package com.tp7.flutter.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tp7.flutter.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
	List<Classe> findByDepartementId(Integer id);
}
