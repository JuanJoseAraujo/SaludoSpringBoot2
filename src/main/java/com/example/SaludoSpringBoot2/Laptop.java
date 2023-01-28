package com.example.SaludoSpringBoot2;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float pulgadas;
    private int ramMB;
    String procesador;

    public Laptop() {
    }

    public Laptop(Long id, float pulgadas, int ramMB, String procesador) {
        this.id = id;
        this.pulgadas = pulgadas;
        this.ramMB = ramMB;
        this.procesador = procesador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getRamMB() {
        return ramMB;
    }

    public void setRamMB(int ramMB) {
        this.ramMB = ramMB;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
}
