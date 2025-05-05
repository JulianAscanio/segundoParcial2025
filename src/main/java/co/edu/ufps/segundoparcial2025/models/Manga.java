package co.edu.ufps.segundoparcial2025.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Date fechaLanzamiento;
    private Integer temporadas;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais_id;

    private boolean anime;
    private boolean juego;
    private boolean pelicula;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo_id;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "usuario_manga",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios;
}