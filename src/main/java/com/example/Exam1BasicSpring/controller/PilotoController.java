package com.example.Exam1BasicSpring.controller;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Pasajero;
import com.example.Exam1BasicSpring.entity.Piloto;
import com.example.Exam1BasicSpring.service.PasajeroService;
import com.example.Exam1BasicSpring.service.PilotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/piloto")
public class PilotoController {
    @Autowired
    private  PilotoService pilotoService;

    @PostMapping("/save")
    public ResponseBase savePiloto(@RequestBody Piloto piloto)
    {
        return pilotoService.savePiloto(piloto);
    }

    @GetMapping("/get/{id}")
    public ResponseBase findById(@PathVariable Integer id)
    {
        ResponseBase responseBase = pilotoService.findPilotoById(id);
        return responseBase;
    }
}
