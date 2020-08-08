package com.sofiaq.mangarestapi.service;

import com.sofiaq.mangarestapi.domain.Manga;
import com.sofiaq.mangarestapi.exception.ResourceNotFoundException;
import com.sofiaq.mangarestapi.repository.MangaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MangaService {
    
    private final MangaRepository mangaRepository;

    public MangaService(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }
  
    public ResponseEntity<List<Manga>> buscarTodos(){
        List<Manga> mangas = (List<Manga>) mangaRepository.findAll();
        if(mangas.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
             return new ResponseEntity<>(mangas, HttpStatus.OK);
        }
    }
    
    public ResponseEntity<Manga> guardarManga(Manga manga){
        return new ResponseEntity<>(mangaRepository.save(manga), HttpStatus.CREATED);
    }
    
    public ResponseEntity<Manga> actualizarManga(int id, Manga m){
        Manga manga = mangaRepository.findById(id)
                      .orElseThrow(()-> new ResourceNotFoundException("no existe manga con dicho id"));
        manga.setNombre(m.getNombre());
        manga.setAutor(m.getAutor());
        manga.setDescripcion(m.getDescripcion());
        manga.setImagenUrl(m.getImagenUrl());
        
        
        return new ResponseEntity<>(mangaRepository.save(manga), HttpStatus.OK);
    }
    
    public ResponseEntity<Manga> mangaById(int id){
        Manga manga = mangaRepository.findById(id)
                      .orElseThrow( ()-> new ResourceNotFoundException("No se encontró manga"));
        return new ResponseEntity<>(manga, HttpStatus.OK);
    }
    
    public ResponseEntity<Manga> eliminarManga(int id){
        Manga manga = mangaRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("No se pudo eliminar manga"));
        mangaRepository.delete(manga);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
