package com.sofiaq.mangarestapi.service;

import com.sofiaq.mangarestapi.domain.Autor;
import com.sofiaq.mangarestapi.repository.AutorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    
    public List<Autor> todosLosAutores(){
        return (List<Autor>) autorRepository.findAll();
    }
    
    public Autor guardarAutor (Autor autor){
        return autorRepository.save(autor);
    }
}
