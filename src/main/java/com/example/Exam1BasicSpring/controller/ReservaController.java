package com.example.Exam1BasicSpring.controller;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Reserva;
import com.example.Exam1BasicSpring.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reserva")

public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/save")
    public ResponseBase saveReserva(@RequestBody Reserva reserva)
    {
        return reservaService.saveReserva(reserva);
    }

    @GetMapping("/get/{id}")
    public ResponseBase findReservaById(@PathVariable Integer id)
    {
        return reservaService.findReservaById(id);
    }
}
