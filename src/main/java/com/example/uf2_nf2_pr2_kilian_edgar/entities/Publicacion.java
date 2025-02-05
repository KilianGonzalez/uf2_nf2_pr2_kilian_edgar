package com.example.uf2_nf2_pr2_kilian_edgar.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Publicacion {

    //Campos tabla Publicaciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String contenido;

    @CreationTimestamp
    private LocalDate f_creacion;

    //Constructores
    public Publicacion() {
    }

    public Publicacion(String titulo, String contenido, LocalDate f_creacion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.f_creacion = f_creacion;
    }

    //Relaciones
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Comentario> comentarios;

    //Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Publicaciones{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", f_creacion=" + f_creacion +
                ", comentarios=" + comentarios +
                '}';
    }
}
