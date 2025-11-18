package com.tp7.flutter.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomDept;

    @OneToMany(mappedBy = "departement")
    private List<Classe> classes;
}
