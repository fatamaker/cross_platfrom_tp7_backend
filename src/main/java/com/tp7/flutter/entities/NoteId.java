package com.tp7.flutter.entities;

import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteId implements Serializable {

    private Integer etudiant;  // correspond à #NCE
    private Integer matiere;   // correspond à #CodMat
}
