package co.edu.ufps.segundoparcial2025.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "favorito")
@IdClass(FavoritoId.class)
public class Favorito {
    @Id
    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;

    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

