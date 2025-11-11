package com.tp7.flutter.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tp7.flutter.entities.User;
import com.tp7.flutter.repos.UserRepository;
import com.tp7.flutter.config.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder; // Pour hasher le mot de passe

    // -------------------- REGISTER --------------------
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        // Vérifie si l’email existe déjà
        if (userRepository.existsByEmail(user.getEmail())) {
            response.put("error", "Email déjà utilisé !");
            return response;
        }

        // Hasher le mot de passe avant de sauvegarder
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Sauvegarde de l'utilisateur
        User savedUser = userRepository.save(user);

        // Génération du token JWT
        String token = jwtUtil.generateToken(savedUser.getEmail());

        // Préparer la réponse
        response.put("user", savedUser);
        response.put("token", token);

        return response;
    }

    // -------------------- LOGIN --------------------
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        // Cherche l'utilisateur par email
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            // Mot de passe correct → générer token
            String token = jwtUtil.generateToken(existingUser.getEmail());
            response.put("user", existingUser);
            response.put("token", token);
        } else {
            response.put("error", "Email ou mot de passe incorrect");
        }

        return response;
    }
}