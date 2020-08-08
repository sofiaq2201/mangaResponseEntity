package com.sofiaq.mangarestapi.controller;

import com.sofiaq.mangarestapi.domain.Autor;
import com.sofiaq.mangarestapi.service.AutorService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }
    
    @GetMapping()
    public List<Autor> todosLosAutores(){
        return autorService.todosLosAutores();
    }
    
    @PostMapping()
    public Autor guardarAutor(@RequestBody Autor autor){
        
        return this.autorService.guardarAutor(autor);
        
        
    }
    
}
