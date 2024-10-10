package com.proyectonotas.prueba2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectonotas.prueba2.entity.Nota;
import com.proyectonotas.prueba2.repository.NotaRepository;

@Service
public class NotaService {
    @Autowired
    private NotaRepository notaRepository;
    public List<Nota> listarNotas() {
        return notaRepository.findAll();
    }

    public Nota guardarNota(Nota nota) {
        // Validación de puntajes
        if (nota.getActividades() > 35 || 
            nota.getPrimerParcial() > 15 || 
            nota.getSegundoParcial() > 15 || 
            nota.getExamenFinal() > 35) {
            throw new IllegalArgumentException("Los puntajes exceden los límites permitidos");
        }
        nota.setPuntajeTotal(nota.calcularPuntajeTotal());
        return notaRepository.save(nota);
    }

    public Nota obtenerNotaPorId(Long id) {
        return notaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nota no encontrada"));
    }

    public void eliminarNota(Long id) {
        notaRepository.deleteById(id);
    }

}
