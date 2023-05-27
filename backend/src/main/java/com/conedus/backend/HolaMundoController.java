package com.conedus.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class HolaMundoController {
    @GetMapping("/hola")
    public String hola(){
        return "Hola mundo";
    }
}
