package com.tp7.flutter.entities;



import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassMatId implements Serializable {

    @Column(name = "cod_mat")
    private String codMat;

    @Column(name = "cod_class")
    private String codClass;
}
