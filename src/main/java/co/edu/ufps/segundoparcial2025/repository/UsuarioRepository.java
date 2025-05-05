package co.edu.ufps.segundoparcial2025.repository;

import co.edu.ufps.segundoparcial2025.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
