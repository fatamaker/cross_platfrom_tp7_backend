package com.tp7.flutter.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp7.flutter.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	   User findByEmail(String email); // pour l’authentification
	    // Vérifie si l’email existe déjà
	    boolean existsByEmail(String email);
}
