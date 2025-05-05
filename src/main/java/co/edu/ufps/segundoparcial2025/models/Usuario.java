package co.edu.ufps.segundoparcial2025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String nombre;
    private String email;
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "usuarios")
    private List<Manga> mangas;
}