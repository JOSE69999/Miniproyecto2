package com.proyectonotas.prueba2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectonotas.prueba2.entity.Nota;
import com.proyectonotas.prueba2.service.NotaService;


@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    // Listar notas
    @GetMapping
    public List<Nota> listarNotas() {
        return notaService.listarNotas();
    }

    // Registrar una nueva nota
    @PostMapping
    public ResponseEntity<Nota> registrarNota(@RequestBody Nota nota) {
        Nota nuevaNota = notaService.guardarNota(nota);
        return ResponseEntity.ok(nuevaNota);
    }

    // Obtener una nota por ID
    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerNota(@PathVariable Long id) {
        Nota nota = notaService.obtenerNotaPorId(id);
        
        return ResponseEntity.ok(nota);
    }

    // Actualizar una nota existente
    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizarNota(@PathVariable Long id, @RequestBody Nota notaActualizada) {
        notaActualizada.setId(id); // Establece el ID de la nota que se actualizará
        Nota nota = notaService.guardarNota(notaActualizada);
        return ResponseEntity.ok(nota);
    }

    // Eliminar una nota
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        notaService.eliminarNota(id);
        return ResponseEntity.noContent().build();
    }
}
