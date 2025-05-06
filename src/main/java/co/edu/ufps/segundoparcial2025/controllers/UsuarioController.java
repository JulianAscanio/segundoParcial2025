package co.edu.ufps.segundoparcial2025.controllers;

import co.edu.ufps.segundoparcial2025.models.Favorito;
import co.edu.ufps.segundoparcial2025.models.FavoritoId;
import co.edu.ufps.segundoparcial2025.models.Manga;
import co.edu.ufps.segundoparcial2025.models.Usuario;
import co.edu.ufps.segundoparcial2025.services.MangaService;
import co.edu.ufps.segundoparcial2025.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MangaService mangaService;


    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable int id) {
        return usuarioService.findById(id);
    }

    @GetMapping("/{username}/favoritos")
    public ResponseEntity<?> getFavoritos(@PathVariable String username) {
        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario == null){
            return ResponseEntity.status(404).body(Map.of("error", true,"msg", "Usuario no encontrado"));
        }
        List<Manga> favoritos = usuario.getFavoritos().stream()
                .map(Favorito::getManga).collect(Collectors.toList());

        return ResponseEntity.ok(favoritos);
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PostMapping("/{username}/favoritos")
    public ResponseEntity<?> addFavorito(@PathVariable String username, @RequestBody Manga mangaR) {
        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario == null) {
            return ResponseEntity.status(404).body(Map.of("error", true, "msg", "Usuario no encontrado"));
        }

        Manga manga = mangaService.findById(mangaR.getId());
        if (manga == null){
            return ResponseEntity.status(404).body(Map.of("error", true, "msg", "Manga no encontrado"));
        }

        boolean existeFav = usuario.getFavoritos().stream().
                anyMatch(f -> f.getManga().getId().equals(manga.getId()));

        if (existeFav){
            return ResponseEntity.status(400)
                    .body(Map.of("error", true, "msg", "Favorito ya se encuentra registrado"));
        }

        Favorito favorito = new Favorito();
        favorito.setId(new FavoritoId(usuario.getId(), manga.getId()));
        favorito.setUsuario(usuario);
        favorito.setManga(manga);
        usuario.getFavoritos().add(favorito);

        usuarioService.save(usuario);

        return  ResponseEntity.ok(favorito);
    }


    @DeleteMapping("/{username}/favoritos/{mangaId}")
    public ResponseEntity<?> removeFavorito(@PathVariable String username, @PathVariable int mangaId) {
        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario == null) {
            return ResponseEntity.status(404).body(Map.of("error", true, "msg", "Usuario no encontrado"));
        }

        Favorito favorito = usuario.getFavoritos().stream()
                .filter(f -> f.getManga().getId() == mangaId)
                .findFirst()
                .orElse(null);

        if (favorito == null) {
            return ResponseEntity.status(404).body(Map.of("error", true, "msg", "Manga no está en favoritos"));
        }

        usuario.getFavoritos().remove(favorito);
        usuarioService.save(usuario);

        return ResponseEntity.ok(Map.of("msg", "Manga eliminado de favoritos"));
    }
}
