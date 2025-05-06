package co.edu.ufps.segundoparcial2025.services;

import co.edu.ufps.segundoparcial2025.models.Manga;
import co.edu.ufps.segundoparcial2025.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public List<Manga> findAll() {
        return mangaRepository.findAll();
    }

    public Manga findById(int id) {
        return mangaRepository.findById(id).orElse(null);
    }

    public Manga save(Manga manga) {
        return mangaRepository.save(manga);
    }

    public void deleteById(int id) {
        mangaRepository.deleteById(id);
    }

    public Manga getManga(int id) {
        try {
            return mangaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
