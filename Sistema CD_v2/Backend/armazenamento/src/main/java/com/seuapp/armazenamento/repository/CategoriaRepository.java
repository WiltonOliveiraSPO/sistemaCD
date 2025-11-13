package com.seuapp.armazenamento.repository;

import com.seuapp.armazenamento.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}