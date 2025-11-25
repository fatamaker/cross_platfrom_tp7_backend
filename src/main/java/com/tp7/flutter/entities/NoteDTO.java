package com.tp7.flutter.entities;


import lombok.Data;

@Data
public class NoteDTO {
	private Integer etudiantId;
    private Integer codMat;
    private Double valeurNote;
}