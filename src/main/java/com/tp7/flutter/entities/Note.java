package com.tp7.flutter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(NoteId.class)
public class Note {

    @Id
    private Long etudiantId;

    @Id
    private Long codMat;

    private Double valeurNote;
}