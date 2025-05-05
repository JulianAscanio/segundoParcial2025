package co.edu.ufps.segundoparcial2025.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

}

