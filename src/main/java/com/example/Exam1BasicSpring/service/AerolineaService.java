package com.example.Exam1BasicSpring.service;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Aerolinea;
import com.example.Exam1BasicSpring.repository.AerolineaRepository;
import org.apache.coyote.Response;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AerolineaService {
    @Autowired
    private AerolineaRepository aerolineaRepository;

    public ResponseBase saveAerolinea(Aerolinea aerolinea)
    {
        Optional<Aerolinea> aerolinea1 = aerolineaRepository.findByNombre(aerolinea.getNombre());
        if(aerolinea1.isPresent())
        {
           return new ResponseBase(400,"Aerolinea con el nombre "+aerolinea1.get().getNombre()+" ya existe",false,Optional.empty());
        }

        return new ResponseBase(201,"Aerolinea "+aerolinea.getNombre()+" creada",true,Optional.of(aerolineaRepository.save(aerolinea)));
    }

    public ResponseBase findAerolinea(Integer id)
    {
        Optional<Aerolinea> aerolinea = aerolineaRepository.findById(id);
        if(aerolinea.isPresent())
        {
            return new ResponseBase(200,"Aerolinea encontrada",true,aerolinea);
        }
        return new ResponseBase(404,"No se ha encontrado",false,Optional.empty());
    }

}
