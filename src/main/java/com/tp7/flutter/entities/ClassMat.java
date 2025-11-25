package com.tp7.flutter.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "classmat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassMat {

    @EmbeddedId
    private ClassMatId id;

    @Column(nullable = false)
    private double coef;

    @Column(nullable = false)
    private int chsm;

    // Relations vers Matiere & Classe (facultatif mais recommandé)
    @ManyToOne
    @MapsId("codMat")
    @JoinColumn(name = "cod_mat")
    private Matiere matiere;

    @ManyToOne
    @MapsId("codClass")
    @JoinColumn(name = "cod_class")
    private Classe classe;
}
