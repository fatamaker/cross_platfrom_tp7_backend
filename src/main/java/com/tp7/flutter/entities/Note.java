package com.tp7.flutter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(NoteId.class)
public class Note {

    @Id
    @ManyToOne
    @JoinColumn(name = "NCE")
    private Etudiant etudiant;

    @Id
    @ManyToOne
    @JoinColumn(name = "CodMat")
    private Matiere matiere;

    private double valeurNote;
}
