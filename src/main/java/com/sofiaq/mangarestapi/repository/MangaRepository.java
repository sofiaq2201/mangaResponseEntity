package com.sofiaq.mangarestapi.repository;

import com.sofiaq.mangarestapi.domain.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface MangaRepository extends JpaRepository<Manga, Integer>{
    
}
