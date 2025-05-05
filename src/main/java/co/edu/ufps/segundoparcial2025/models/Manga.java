package co.edu.ufps.segundoparcial2025.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "fecha_lanzamiento")
    private LocalDate fechaLanzamiento;

    private Integer temporadas;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    private Integer anime;
    private Integer juego;
    private Integer pelicula;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    @ManyToMany(mappedBy = "favoritos")
    private Set<Usuario> usuariosQueLoFav;

    @ManyToOne
    @JoinColumn(name = "usuario_id") // FK en la tabla manga
    private Usuario usuario;

}
