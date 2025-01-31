package com.example.uf2_nf2_pr2_kilian_edgar.controllers;

import com.example.uf2_nf2_pr2_kilian_edgar.entities.Comentario;
import com.example.uf2_nf2_pr2_kilian_edgar.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/comments")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public String getAllComentarios(){return comentarioService.getAllComentarios();}

    @PostMapping
    public String addComentario(@RequestBody Comentario comentario) {return comentarioService.addComentario(comentario);}
}
