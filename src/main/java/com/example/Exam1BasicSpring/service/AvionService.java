package com.example.Exam1BasicSpring.service;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Avion;
import com.example.Exam1BasicSpring.repository.AvionRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvionService {
    @Autowired
    AvionRepository avionRepository;

    public ResponseBase saveAvion(Avion avion)
    {
        Optional<Avion> avion1 = avionRepository.findByModelo(avion.getModelo());
        if(avion1.isPresent())
        {
            return new ResponseBase(400,"Avion "+(Integer.toString(avion1.get().getId()))+" ya existe",false,Optional.empty());
        }
        return new ResponseBase(201,"Avion creado",true,Optional.of(avionRepository.save(avion)));
    }

    public ResponseBase findAvionById(Integer id)
    {
        Optional<Avion> avion1 = avionRepository.findById(id);
        if(avion1.isPresent())
        {
            return new ResponseBase(200,"Avion encontrado",true,Optional.of(avion1));
        }
        return new ResponseBase(404,"No se ha encontrado el avion",false,Optional.empty());
    }

}
