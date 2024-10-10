package com.proyectonotas.prueba2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectonotas.prueba2.entity.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    
}
