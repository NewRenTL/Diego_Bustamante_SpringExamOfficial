package com.example.Exam1BasicSpring.controller;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Avion;
import com.example.Exam1BasicSpring.entity.Pasajero;
import com.example.Exam1BasicSpring.service.AvionService;
import com.example.Exam1BasicSpring.service.PasajeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pasajero")

public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @PostMapping("/save")
    public ResponseBase saveAvion(@RequestBody Pasajero pasajero)
    {
        return pasajeroService.savePasajero(pasajero);
    }

    @GetMapping("/get/{id}")
    public ResponseBase findById(@PathVariable Integer id)
    {
        ResponseBase responseBase = pasajeroService.findPasajeroById(id);
        return responseBase;
    }
}
