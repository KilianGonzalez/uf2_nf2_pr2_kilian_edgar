package com.example.uf2_nf2_pr2_kilian_edgar.controllers;

import com.example.uf2_nf2_pr2_kilian_edgar.entities.Comentario;
import com.example.uf2_nf2_pr2_kilian_edgar.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/publicacion/{publicacionId}/comentario")
    public List<Comentario> getComentariosByPublicacion(@PathVariable long publicacionId) {return comentarioService.getComentariosByPublicacion(publicacionId);}

    @PostMapping("/publicacion/{publicacionId}/comentario")
    public String addComentario(@PathVariable long publicacionId, @RequestBody Comentario comentario) {return comentarioService.addComentario(publicacionId, comentario);}

    @DeleteMapping("/{id}")
    public String deleteComentario(@PathVariable long id) {return comentarioService.deleteComentario(id);}
}
