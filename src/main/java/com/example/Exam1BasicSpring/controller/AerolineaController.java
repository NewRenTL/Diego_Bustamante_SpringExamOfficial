package com.example.Exam1BasicSpring.controller;


import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Aerolinea;
import com.example.Exam1BasicSpring.service.AerolineaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aerolinea")
public class AerolineaController {

    @Autowired
    private  AerolineaService aerolineaService;

    @PostMapping("/save")
    public ResponseBase saveAerolinea(@RequestBody Aerolinea aerolinea)
    {
        return aerolineaService.saveAerolinea(aerolinea);
    }
    @GetMapping( "/get/{id}")
    public ResponseBase findById(@PathVariable Integer id)
    {
        ResponseBase responseBase = aerolineaService.findAerolinea(id);
        return responseBase;
    }
}
