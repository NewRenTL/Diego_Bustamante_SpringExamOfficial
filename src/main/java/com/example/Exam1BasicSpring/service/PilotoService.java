package com.example.Exam1BasicSpring.service;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Pasajero;
import com.example.Exam1BasicSpring.entity.Piloto;
import com.example.Exam1BasicSpring.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PilotoService {
    @Autowired
    PilotoRepository pilotoRepository;

    public ResponseBase savePiloto(Piloto piloto)
    {
        Optional<Piloto> piloto1 = pilotoRepository.findByAtributosIguales(piloto.getNombre(),piloto.getApellido());
        if(piloto1.isPresent())
        {
            return new ResponseBase(400,"Piloto "+(Integer.toString(piloto1.get().getPiloto_id()))+" ya existe",false,Optional.empty());
        }
        return new ResponseBase(201,"Piloto creado",true,Optional.of(pilotoRepository.save(piloto)));
    }

    public ResponseBase findPilotoById(Integer id)
    {
        Optional<Piloto> piloto = pilotoRepository.findById(id);
        if(piloto.isPresent())
        {
            return new ResponseBase(200,"Piloto encontrado",true,piloto);
        }
        return new ResponseBase(404,"No se ha encontrado",false,Optional.empty());
    }
}
