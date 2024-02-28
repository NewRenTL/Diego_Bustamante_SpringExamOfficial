package com.example.Exam1BasicSpring.controller;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Avion;
import com.example.Exam1BasicSpring.entity.Vuelo;
import com.example.Exam1BasicSpring.repository.VueloRepository;
import com.example.Exam1BasicSpring.service.VueloService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vuelo")

public class VueloController {
    @Autowired
    private  VueloService vueloService;

    @PostMapping("/save")
    public ResponseBase saveVuelo(@RequestBody Vuelo vuelo)
    {
        return vueloService.saveVuelo(vuelo);
    }

    @GetMapping("/get/{id}")
    public ResponseBase findAvionById(@PathVariable Integer id)
    {
        return vueloService.findVueloById(id);
    }
}
