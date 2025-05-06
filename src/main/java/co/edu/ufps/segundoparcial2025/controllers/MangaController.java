package co.edu.ufps.segundoparcial2025.controllers;

import co.edu.ufps.segundoparcial2025.models.Manga;
import co.edu.ufps.segundoparcial2025.services.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mangas")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @GetMapping
    public List<Manga> findAll() {
        return mangaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Manga manga = mangaService.findById(id);
        if (manga == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", true);
            error.put("msg", "Objeto no encontrado");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(manga);
    }

    @PostMapping
    public Manga save(@RequestBody Manga manga) {
        return mangaService.save(manga);
    }

    @PutMapping("/{id}")
    public Manga update(@PathVariable int id, @RequestBody Manga manga) {
        Manga existingManga = mangaService.findById(id);
        if (existingManga != null) {
            manga.setId(id);
            return mangaService.save(manga);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Manga deleteById(@PathVariable int id) {
        Manga manga = mangaService.findById(id);
        if (manga != null) {
            mangaService.deleteById(id);
        }
        return manga;
    }
}