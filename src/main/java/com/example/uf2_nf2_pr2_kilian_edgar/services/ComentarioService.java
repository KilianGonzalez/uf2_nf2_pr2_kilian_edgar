package com.example.uf2_nf2_pr2_kilian_edgar.services;

import com.example.uf2_nf2_pr2_kilian_edgar.entities.Comentario;
import com.example.uf2_nf2_pr2_kilian_edgar.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public String getAllComentarios() {return comentarioRepository.findAll().toString();}

    public String addComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
        return "Comentario added succesfully";
    }
}
