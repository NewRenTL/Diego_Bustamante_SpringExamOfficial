package com.example.Exam1BasicSpring.controller;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Avion;
import com.example.Exam1BasicSpring.service.AvionService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/avion")
public class AvionController {
    @Autowired
    private AvionService avionService;

    @PostMapping("/save")
    public ResponseBase saveAvion(@RequestBody Avion avion)
    {
        return avionService.saveAvion(avion);
    }

    @GetMapping("/get/{id}")
    public ResponseBase findById(@PathVariable Integer id)
    {
        ResponseBase responseBase = avionService.findAvionById(id);
        return responseBase;
    }
}
