package co.edu.ufps.segundoparcial2025.repository;

import co.edu.ufps.segundoparcial2025.models.Favorito;
import co.edu.ufps.segundoparcial2025.models.FavoritoId;
import co.edu.ufps.segundoparcial2025.models.Manga;
import co.edu.ufps.segundoparcial2025.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoId> {
    List<Favorito> findByUsuario(Usuario usuario);
    boolean existsByManga(Manga manga);
}
