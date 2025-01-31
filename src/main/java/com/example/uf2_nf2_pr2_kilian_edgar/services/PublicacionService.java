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

    public String getPublicacionById(long id) {
        Publicacion publicacion = publicacionRepository.findById(id);
        if (publicacion == null) {
            return "Publicacion doesn't exist";
        }
        return publicacion.toString();
    }

    public String addPublicacion(Publicacion publicacion) {
        publicacionRepository.save(publicacion);
        return "Publicacion added succesfully";
    }

    public String updatePublicacion(long id, Publicacion nuevaPublicacion) {
        Publicacion publicacionExistente = publicacionRepository.findById(id);

        if (publicacionExistente == null) {
            return "Publicacion doesn't exist";
        }

        if (nuevaPublicacion.getTitulo() != null && !nuevaPublicacion.getTitulo().isEmpty()) {
            publicacionExistente.setTitulo(nuevaPublicacion.getTitulo());
        }

        if (nuevaPublicacion.getContenido() != null && !nuevaPublicacion.getContenido().isEmpty()) {
            publicacionExistente.setContenido(nuevaPublicacion.getContenido());
        }

        publicacionRepository.save(publicacionExistente);

        return "Publicacion updated successfully";
    }

    public String deletePublicacion(long id) {
        Publicacion publicacion = publicacionRepository.findById(id);
        if (publicacion == null) {
            return "Publication doesn't exist";
        }
        publicacionRepository.deleteById(id);
        return "Publication deleted succesfully";
    }
}
