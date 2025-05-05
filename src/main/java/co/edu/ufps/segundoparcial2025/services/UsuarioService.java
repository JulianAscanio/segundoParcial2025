package co.edu.ufps.segundoparcial2025.services;

import co.edu.ufps.segundoparcial2025.models.Usuario;
import co.edu.ufps.segundoparcial2025.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(int id) {
        usuarioRepository.deleteById(id);
    }
}
