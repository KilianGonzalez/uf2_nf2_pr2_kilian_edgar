package com.example.uf2_nf2_pr2_kilian_edgar.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Comentario {
    //Campos tabla Comentario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String contenido;

    @CreationTimestamp
    private LocalDate f_creacion;

    //Constructores
    public Comentario() {
    }

    public Comentario(String contenido, LocalDate f_creacion) {
        this.contenido = contenido;
        this.f_creacion = f_creacion;
    }

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    @JsonBackReference
    private Publicacion publicacion;

    //Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(LocalDate f_creacion) {
        this.f_creacion = f_creacion;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", contenido='" + contenido + '\'' +
                ", f_creacion=" + f_creacion +
                ", publicacion=" + publicacion +
                '}';
    }
}
