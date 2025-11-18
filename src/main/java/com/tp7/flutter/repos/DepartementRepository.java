package com.tp7.flutter.repos;


import com.tp7.flutter.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
