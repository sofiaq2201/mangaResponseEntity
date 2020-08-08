package com.sofiaq.mangarestapi.repository;

import com.sofiaq.mangarestapi.domain.Manga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface MangaRepository extends CrudRepository<Manga, Integer>{
    
}
