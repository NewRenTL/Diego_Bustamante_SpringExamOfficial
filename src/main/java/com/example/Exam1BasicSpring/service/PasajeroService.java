package com.example.Exam1BasicSpring.service;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Pasajero;
import com.example.Exam1BasicSpring.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasajeroService {
    @Autowired
    PasajeroRepository pasajeroRepository;

    public ResponseBase savePasajero(Pasajero pasajero)
    {
        Optional<Pasajero> pasajero1 = pasajeroRepository.findByNombre(pasajero.getNombre());
        if(pasajero1.isPresent())
        {
            return new ResponseBase(400,"Pasajero "+(Integer.toString(pasajero1.get().getPasajero_id()))+" ya existe",false,Optional.empty());
        }
        return new ResponseBase(201,"Pasajero creado",true,Optional.of(pasajeroRepository.save(pasajero)));
    }

    public ResponseBase findPasajeroById(Integer id)
    {
        Optional<Pasajero> pasajero = pasajeroRepository.findById(id);
        if(pasajero.isPresent())
        {
            return new ResponseBase(200,"Pasajero encontrado",true,pasajero);
        }
        return new ResponseBase(404,"No se ha encontrado",false,Optional.empty());
    }
}
