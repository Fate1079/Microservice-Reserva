package com.example.MicroService_Reserva.Persistenc.Repository;







import org.springframework.stereotype.Repository;
import com.example.MicroService_Reserva.Domian.DTO.ReservaDTO;

import java.util.ArrayList;
import java.util.List;



@Repository
public class ReservaRepository {

    private final List<ReservaDTO> baseDeDatos = new ArrayList<>();

    public ReservaDTO save(ReservaDTO reserva) {
        baseDeDatos.add(reserva);
        return reserva;
    }

    public ReservaDTO findById(String id) {
        for (ReservaDTO reserva : baseDeDatos) {
            if (reserva.getId().equals(id)) {
                return reserva;
            }
        }
        return null;
    }

    public List<ReservaDTO> findAll() {
        return new ArrayList<>(baseDeDatos);
    }

    public void deleteById(String id) {
        for (int i = 0; i < baseDeDatos.size(); i++) {
            if (baseDeDatos.get(i).getId().equals(id)) {
                baseDeDatos.remove(i);
                return;
            }
        }
    }

    public ReservaDTO update(ReservaDTO reserva) {
        for (int i = 0; i < baseDeDatos.size(); i++) {
            if (baseDeDatos.get(i).getId().equals(reserva.getId())) {
                baseDeDatos.set(i, reserva);
                return reserva;
            }
        }
        return null;
    }

    // Métodos específicos para reservas

    public List<ReservaDTO> findByUsuario(String usuario) {
        List<ReservaDTO> resultado = new ArrayList<>();
        for (ReservaDTO reserva : baseDeDatos) {
            if (reserva.getUsuario() != null && reserva.getUsuario().contains(usuario)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public List<ReservaDTO> findByEstado(String estado) {
        List<ReservaDTO> resultado = new ArrayList<>();
        for (ReservaDTO reserva : baseDeDatos) {
            if (estado.equals(reserva.getEstado())) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public List<ReservaDTO> findByProducto(String producto) {
        List<ReservaDTO> resultado = new ArrayList<>();
        for (ReservaDTO reserva : baseDeDatos) {
            if (reserva.getProducto() != null && reserva.getProducto().contains(producto)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public List<ReservaDTO> findByFecha(String fecha) {
        List<ReservaDTO> resultado = new ArrayList<>();
        for (ReservaDTO reserva : baseDeDatos) {
            if ((reserva.getFechaInicio() != null && reserva.getFechaInicio().contains(fecha)) ||
                    (reserva.getFechaFinal() != null && reserva.getFechaFinal().contains(fecha))) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public List<ReservaDTO> buscarPorFiltros(String usuario, String estado, String producto, String fecha) {
        List<ReservaDTO> resultado = new ArrayList<>();
        for (ReservaDTO reserva : baseDeDatos) {
            boolean coincideUsuario = (usuario == null ||
                    (reserva.getUsuario() != null && reserva.getUsuario().contains(usuario)));
            boolean coincideEstado = (estado == null || estado.equals(reserva.getEstado()));
            boolean coincideProducto = (producto == null ||
                    (reserva.getProducto() != null && reserva.getProducto().contains(producto)));
            boolean coincideFecha = (fecha == null ||
                    (reserva.getFechaInicio() != null && reserva.getFechaInicio().contains(fecha)) ||
                    (reserva.getFechaFinal() != null && reserva.getFechaFinal().contains(fecha)));

            if (coincideUsuario && coincideEstado && coincideProducto && coincideFecha) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public ReservaDTO findByCodigo(String codigo) {
        for (ReservaDTO reserva : baseDeDatos) {
            if (codigo.equals(reserva.getCodigo())) {
                return reserva;
            }
        }
        return null;
    }

    public boolean existsById(String id) {
        return findById(id) != null;
    }

    public boolean existsByCodigo(String codigo) {
        return findByCodigo(codigo) != null;
    }

    public long count() {
        return baseDeDatos.size();
    }

    public long countByEstado(String estado) {
        long contador = 0;
        for (ReservaDTO reserva : baseDeDatos) {
            if (estado.equals(reserva.getEstado())) {
                contador++;
            }
        }
        return contador;
    }
}
