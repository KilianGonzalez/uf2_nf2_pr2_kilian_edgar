package com.example.uf2_nf2_pr2_kilian_edgar.services;

import com.example.uf2_nf2_pr2_kilian_edgar.entities.Publicacion;
import com.example.uf2_nf2_pr2_kilian_edgar.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    public String getAllPublicaciones() {return publicacionRepository.findAll().toString();}

    public String addPublicacion(Publicacion publicacion) {
        publicacionRepository.save(publicacion);
        return "Publicacion added succesfully";
    }

    public String deletePublicacion(long id) {
        publicacionRepository.deleteById(id);
        return "Publicacion deleted succesfully";
    }
}
