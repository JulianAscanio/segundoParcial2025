package co.edu.ufps.segundoparcial2025.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class Favorito implements Serializable {

    private Usuario usuario_id;
    private Manga manga_id;

}

