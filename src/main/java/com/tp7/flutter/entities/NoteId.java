package com.tp7.flutter.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteId implements Serializable {
    private Long etudiantId;
    private Long codMat;
}