package co.edu.ufps.segundoparcial2025.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String nombre;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany
    @JoinTable(
            name = "favorito",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "manga_id")
    )
    private Set<Manga> favoritos;
}
