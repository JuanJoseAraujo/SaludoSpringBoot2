package com.example.SaludoSpringBoot2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${app.mensaje}")
    String mensaje;
    @GetMapping("/api/hola")
    public String Saludo(){
        System.out.println(mensaje);
        String saludo = "Hola, esto es un saludo";
        return saludo;
    }
}
