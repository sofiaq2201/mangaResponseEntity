package com.sofiaq.mangarestapi.controller;

import com.sofiaq.mangarestapi.domain.Manga;
import com.sofiaq.mangarestapi.service.MangaService;
import java.util.List;
import org.springframework.http.HttpStatus;
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
        List<Manga> mangas = mangaService.buscarTodos();
        if(mangas.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
             return new ResponseEntity<>(mangas, HttpStatus.OK);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Manga> getMangaById(@PathVariable("id") int id){
        return new ResponseEntity<>(mangaService.mangaById(id), HttpStatus.OK);
    }
    
    @PostMapping()
    public ResponseEntity<Manga> guardarManga(@RequestBody Manga manga){
        Manga _manga = mangaService.guardarManga(manga);
        return new ResponseEntity<>(_manga, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Manga> actualizarManga(@PathVariable("id") int id, @RequestBody Manga m){
        return new ResponseEntity<>(mangaService.actualizarManga(id, m), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Manga> eliminarManga(@PathVariable int id){
        mangaService.eliminarManga(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
