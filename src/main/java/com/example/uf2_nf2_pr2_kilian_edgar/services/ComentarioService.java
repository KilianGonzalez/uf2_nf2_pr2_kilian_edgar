package com.example.uf2_nf2_pr2_kilian_edgar.services;

import com.example.uf2_nf2_pr2_kilian_edgar.entities.Comentario;
import com.example.uf2_nf2_pr2_kilian_edgar.entities.Publicacion;
import com.example.uf2_nf2_pr2_kilian_edgar.repository.ComentarioRepository;
import com.example.uf2_nf2_pr2_kilian_edgar.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PublicacionRepository publicacionRepository;

    public List<Comentario> getComentariosByPublicacion(long publicacionId) {
        return comentarioRepository.findByPublicacionId(publicacionId);
    }

    public String addComentario(long publicacionId, Comentario comentario) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId);

        if (publicacion == null) {
            return "Publicacion doesn't exist";
        }

        comentario.setPublicacion(publicacion);
        comentarioRepository.save(comentario);

        return "Comentario added successfully";
    }

    public String deleteComentario(long id) {
        Comentario comentario = comentarioRepository.findById(id);
        if (comentario == null) {
            return "Comentario doesn't exist";
        }
        comentarioRepository.deleteById(id);
        return "Comentario deleted succesfully";
    }
}
