package com.example.MicroService_Reserva.Persistenc.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String producto;

    @Column(nullable = false)
    private double precio;

    @Enumerated(EnumType.STRING)
    //@Column(nullable = false)
    //private EstadoReserva estado = EstadoReserva.PENDIENTE; // 👈 inicializado aquí

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_final", nullable = false)
    private LocalDateTime fechaFinal;

    @Column(nullable = false)
    private String avion;
}
