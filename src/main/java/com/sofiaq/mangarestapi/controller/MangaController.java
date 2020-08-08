package com.sofiaq.mangarestapi.controller;

import com.sofiaq.mangarestapi.domain.Manga;
import com.sofiaq.mangarestapi.service.MangaService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/manga")
public class MangaController {
    
    private final MangaService mangaService; 

    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Manga>> obtenerMangas(){
        return mangaService.buscarTodos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Manga> getMangaById(@PathVariable("id") int id){
        return mangaService.mangaById(id);
    }
    
    @PostMapping()
    public ResponseEntity<Manga> guardarManga(@RequestBody Manga manga){
        return mangaService.guardarManga(manga);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Manga> actualizarManga(@PathVariable("id") int id, @RequestBody Manga m){
        return mangaService.actualizarManga(id, m);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Manga> eliminarManga(@PathVariable int id){
        return mangaService.eliminarManga(id);
    }
}
