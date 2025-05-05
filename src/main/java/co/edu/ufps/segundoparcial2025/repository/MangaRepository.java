package co.edu.ufps.segundoparcial2025.repository;

import co.edu.ufps.segundoparcial2025.models.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MangaRepository extends JpaRepository<Manga, Integer> {
}
