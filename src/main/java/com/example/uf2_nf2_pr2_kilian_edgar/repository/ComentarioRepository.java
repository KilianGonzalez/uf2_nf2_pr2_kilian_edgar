package com.example.uf2_nf2_pr2_kilian_edgar.repository;

import com.example.uf2_nf2_pr2_kilian_edgar.entities.Comentario;
import com.example.uf2_nf2_pr2_kilian_edgar.entities.Publicacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ComentarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Comentario save(Comentario comentario) {
        entityManager.persist(comentario);
        return comentario;
    }

    public Comentario findById(long id) {return entityManager.find(Comentario.class, id);}

    public List<Comentario> findByPublicacionId(long publicacionId) {
        return entityManager.createQuery("FROM Comentario c WHERE c.publicacion.id = :publicacionId")
                .setParameter("publicacionId", publicacionId)
                .getResultList();
    }

    @Transactional
    public void deleteById(long id) {
        Comentario comentario = findById(id);
        if (comentario != null) {
            entityManager.remove(comentario);
        }
    }
}
