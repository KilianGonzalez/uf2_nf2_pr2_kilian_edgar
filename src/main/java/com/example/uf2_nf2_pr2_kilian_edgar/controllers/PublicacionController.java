package com.example.uf2_nf2_pr2_kilian_edgar.controllers;

import com.example.uf2_nf2_pr2_kilian_edgar.entities.Publicacion;
import com.example.uf2_nf2_pr2_kilian_edgar.services.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public String getAllPublicaciones(){return publicacionService.getAllPublicaciones();}

    @GetMapping("/{id}")
    public String getPublicacionById(@PathVariable long id) {return publicacionService.getPublicacionById(id);}

    @PostMapping
    public String addPublicacion(@RequestBody Publicacion publicacion) {return publicacionService.addPublicacion(publicacion);}

    @PutMapping("/{id}")
    public String updatePublicacion(@PathVariable long id, @RequestBody Publicacion nuevaPublicacion) {return publicacionService.updatePublicacion(id, nuevaPublicacion);}

    @DeleteMapping("/{id}")
    public String deletePublicacion(@PathVariable long id) {return publicacionService.deletePublicacion(id);}
}
