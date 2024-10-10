package com.proyectonotas.prueba2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    
    private String estudiante;
    private int actividades;    // Max 35 puntos
    private int primerParcial;  // Max 15 puntos
    private int segundoParcial; // Max 15 puntos
    private int examenFinal;    // Max 35 puntos
    private int puntajeTotal;

    
    public Nota() {}


    public Nota(String estudiante, int actividades, int primerParcial, int segundoParcial, int examenFinal) {
        this.estudiante = estudiante;
        this.actividades = actividades;
        this.primerParcial = primerParcial;
        this.segundoParcial = segundoParcial;
        this.examenFinal = examenFinal;
        this.puntajeTotal = actividades + primerParcial + segundoParcial + examenFinal;  
    }

    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public int getActividades() {
        return actividades;
    }

    public void setActividades(int actividades) {
        this.actividades = actividades;
        this.puntajeTotal = calcularPuntajeTotal(); 
    }

    public int getPrimerParcial() {
        return primerParcial;
    }

    public void setPrimerParcial(int primerParcial) {
        this.primerParcial = primerParcial;
        this.puntajeTotal = calcularPuntajeTotal();
    }

    public int getSegundoParcial() {
        return segundoParcial;
    }

    public void setSegundoParcial(int segundoParcial) {
        this.segundoParcial = segundoParcial;
        this.puntajeTotal = calcularPuntajeTotal();
    }

    public int getExamenFinal() {
        return this.examenFinal;
    }

    public void setExamenFinal(int examenFinal) {
        this.examenFinal = examenFinal;
        this.puntajeTotal = calcularPuntajeTotal();
    }

    public int getPuntajeTotal() {
        return this.puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal){
        this.puntajeTotal = puntajeTotal;
    }

  
    public int calcularPuntajeTotal() {
        return this.actividades + this.primerParcial + this.segundoParcial + this.examenFinal;
    }
    
}
