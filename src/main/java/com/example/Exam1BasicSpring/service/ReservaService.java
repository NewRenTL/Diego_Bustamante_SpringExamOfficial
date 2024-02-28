package com.example.Exam1BasicSpring.service;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Piloto;
import com.example.Exam1BasicSpring.entity.Reserva;
import com.example.Exam1BasicSpring.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;

    public ResponseBase saveReserva(Reserva reserva)
    {
        /*
        Optional<Reserva> reserva1 = reservaRepository.findById(reserva.getReserva_id());
        if(reserva1.isPresent())
        {
            return new ResponseBase(400,"Reserva "+(Integer.toString(reserva1.get().getReserva_id()))+" ya existe",false,Optional.empty());
        }
        */
        return new ResponseBase(201,"Reserva creada",true,Optional.of(reservaRepository.save(reserva)));
    }
    public ResponseBase findReservaById(Integer id)
    {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        if(reserva.isPresent())
        {
            return new ResponseBase(200,"Reserva encontrado",true,reserva);
        }
        return new ResponseBase(404,"No se ha encontrado",false,Optional.empty());
    }


}
