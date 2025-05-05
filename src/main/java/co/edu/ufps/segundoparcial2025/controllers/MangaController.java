package co.edu.ufps.segundoparcial2025.controllers;

import co.edu.ufps.segundoparcial2025.models.Manga;
import co.edu.ufps.segundoparcial2025.services.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Manga findById(@PathVariable Long id) {
        return mangaService.findById(id);
    }

    @PostMapping
    public Manga save(@RequestBody Manga manga) {
        return mangaService.save(manga);
    }

    @PutMapping("/{id}")
    public Manga update(@PathVariable Long id, @RequestBody Manga manga) {
        Manga existingManga = mangaService.findById(id);
        if (existingManga != null) {
            manga.setId(id);
            return mangaService.save(manga);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Manga deleteById(@PathVariable Long id) {
        Manga manga = mangaService.findById(id);
        if (manga != null) {
            mangaService.deleteById(id);
        }
        return manga;
    }
}