package com.example.MicroService_Reserva.Crud;


import com.example.MicroService_Reserva.Persistenc.Entity.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservaCrudRepository extends CrudRepository<Reserva, Long> {

    // Buscar reservas por usuario
    List<Reserva> findByUsuario(String usuario);

    // Buscar reservas por estado
    List<Reserva> findByEstado(String estado);

    // Buscar reservas por avión
    List<Reserva> findByAvion(String avion);



    //aa//
    //SIIIIUU//
}