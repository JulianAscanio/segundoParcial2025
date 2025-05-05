package co.edu.ufps.segundoparcial2025.repository;

import co.edu.ufps.segundoparcial2025.models.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MangaRepository extends JpaRepository<Manga, Long> {
    List<Manga> findAll();
}
