package com.conedus.backend.controllers;
import com.conedus.backend.handlers.BadRequestException;
import com.conedus.backend.models.SedeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conedus.backend.services.SedeService;

@RestController
@RequestMapping("/sede")
public class SedeController {

    @Autowired
    private SedeService service;

    /**
     * Obtiene 100 sedes
     * 
     * @return Las sedes
     */
    @GetMapping("/sedes")
    @ResponseStatus(HttpStatus.OK)
    public String obtenerSedes() {
        System.out.println("Entra aqui");
        return service.getSedes();
    }

    /**
     * Actualiza una sede por su ID
     * 
     * @return La sede actualizada
     */
    @PutMapping("/prueba")
    @ResponseStatus(HttpStatus.OK)
    public SedeDTO actualizarSede(@RequestBody SedeDTO request) {

        if(request.getSedeDane() == null || request.getSedeDane().equals("")){
            throw new BadRequestException("No se encuentra el id");
        }
        return service.updateSede(request);
    }

    @GetMapping("/filtro")
    public String filtro() {
        return service.filtro();
    }

    @GetMapping("/top")
    public String getTOP() {
        return service.getTOPObjects();
    }

    @GetMapping("/lists")
    public String getLists() {
        return service.getLists();
    }
}
