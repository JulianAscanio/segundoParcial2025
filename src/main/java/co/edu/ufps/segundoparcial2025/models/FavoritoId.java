package co.edu.ufps.segundoparcial2025.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FavoritoId implements Serializable {
    private Integer usuarioId;
    private Integer mangaId;
}