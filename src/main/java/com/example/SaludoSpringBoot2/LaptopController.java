package com.example.SaludoSpringBoot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {


    private LaptopRepository repositorio;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(LaptopRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> listAll(){
        return repositorio.findAll();
    }

    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop){
        repositorio.save(laptop);
        return laptop;
    }

    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById (@PathVariable Long id)
    {
        Optional<Laptop> laptopOptional = repositorio.findById(id);

        if (laptopOptional.isPresent())
        {
            return ResponseEntity.ok(laptopOptional.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {

        if( laptop.getId() == null){
            log.warn("Intentando actualizar un laptop inexistente");
            return ResponseEntity.badRequest().build();
        }
        if (!repositorio.existsById(laptop.getId()))
        {
            log.warn("Intentando actualizar un laptop inexistente");
            return ResponseEntity.notFound().build();
        }

        Laptop result = repositorio.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id)
    {
        if (!repositorio.existsById(id))
        {
            log.warn("Intentando borrar un laptop inexistente");
            return ResponseEntity.notFound().build();
        }

        repositorio.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll()
    {
        repositorio.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
