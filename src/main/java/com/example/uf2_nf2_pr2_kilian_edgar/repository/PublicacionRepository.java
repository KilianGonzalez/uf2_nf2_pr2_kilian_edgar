package com.example.uf2_nf2_pr2_kilian_edgar.repository;

import com.example.uf2_nf2_pr2_kilian_edgar.entities.Publicacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PublicacionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Publicacion save(Publicacion publicacion) {
        entityManager.persist(publicacion);
        return publicacion;
    }

    public Publicacion findById(long id) {return entityManager.find(Publicacion.class, id);}

    public List<Publicacion> findAll() {return entityManager.createQuery("FROM Publicacion p").getResultList();}

    @Transactional
    public void deleteById(long id) {
        Publicacion publicacion = findById(id);
        if (publicacion != null) {
            entityManager.remove(publicacion);
        }
    }
}
