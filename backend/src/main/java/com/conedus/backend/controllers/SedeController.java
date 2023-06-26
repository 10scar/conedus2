package com.conedus.backend.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.conedus.backend.services.SedeService;

@RestController
@RequestMapping("/sede")
public class SedeController {

    private SedeService service = new SedeService();

    /**
     * Obtiene 100 sedes
     * 
     * @return Las sedes
     */
    @GetMapping("/sedes")
    public String obtenerSedes() {
        return service.getSedes();
    }

    /**
     * Actualiza una sede por su ID
     * 
     * @return La sede actualizada
     */
    @PatchMapping("/sede/{id}")
    public String actualizarSede() {
        return "";
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
