package com.example.MicroService_Reserva.Persistenc.Service;

import com.example.MicroService_Reserva.Domian.DTO.ReservaDTO;
import com.example.MicroService_Reserva.Persistenc.Repository.ReservaRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Crear una nueva reserva simulada
    public ReservaDTO crearReservaSimulada(String id) {
        ReservaDTO reserva = new ReservaDTO(id); // Simula automáticamente
        return reservaRepository.save(reserva);
    }

    // Guardar una reserva existente
    public ReservaDTO guardarReserva(ReservaDTO reserva) {
        return reservaRepository.save(reserva);
    }

    // Obtener una reserva por ID
    public ReservaDTO obtenerPorId(String id) {
        return reservaRepository.findById(id);
    }

    // Obtener todas las reservas
    public List<ReservaDTO> obtenerTodas() {
        return reservaRepository.findAll();
    }

    // Actualizar una reserva existente
    public ReservaDTO actualizarReserva(ReservaDTO reserva) {
        return reservaRepository.update(reserva);
    }

    // Eliminar reserva por ID
    public void eliminarPorId(String id) {
        reservaRepository.deleteById(id);
    }

    // Buscar por usuario
    public List<ReservaDTO> buscarPorUsuario(String usuario) {
        return reservaRepository.findByUsuario(usuario);
    }

    // Buscar por estado
    public List<ReservaDTO> buscarPorEstado(String estado) {
        return reservaRepository.findByEstado(estado);
    }

    // Buscar por producto
    public List<ReservaDTO> buscarPorProducto(String producto) {
        return reservaRepository.findByProducto(producto);
    }

    // Buscar por fecha
    public List<ReservaDTO> buscarPorFecha(String fecha) {
        return reservaRepository.findByFecha(fecha);
    }

    // Buscar por código
    public ReservaDTO buscarPorCodigo(String codigo) {
        return reservaRepository.findByCodigo(codigo);
    }

    // Buscar por filtros combinados
    public List<ReservaDTO> buscarPorFiltros(String usuario, String estado, String producto, String fecha) {
        return reservaRepository.buscarPorFiltros(usuario, estado, producto, fecha);
    }

    // Contar total
    public long contarTotal() {
        return reservaRepository.count();
    }

    // Contar por estado
    public long contarPorEstado(String estado) {
        return reservaRepository.countByEstado(estado);
    }

    // Verifica existencia por ID
    public boolean existePorId(String id) {
        return reservaRepository.existsById(id);
    }

    // Verifica existencia por código
    public boolean existePorCodigo(String codigo) {
        return reservaRepository.existsByCodigo(codigo);
    }
}
