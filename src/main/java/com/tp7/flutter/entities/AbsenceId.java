package com.tp7.flutter.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbsenceId implements Serializable {
    private Integer codMat;
    private Integer nce;
    private Date dateA;
}