package Controller;


import DTO.ReservaDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.MicroService_Reserva.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "API para la gestión de reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las reservas", description = "Devuelve la lista de todas las reservas.")
    public ResponseEntity<List<DTO.ReservaDTO>> getAllReservas() {
        return ResponseEntity.ok(reservaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una reserva por ID")
    public ResponseEntity<DTO.ReservaDTO> getReservaById(@PathVariable String id) {
        DTO.ReservaDTO reserva = reservaService.obtenerPorId(id);
        return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }

    @PostMapping("/simulada/{id}")
    @Operation(summary = "Crear una reserva simulada", description = "Genera una reserva con datos simulados según el ID.")
    public ResponseEntity<ReservaDTO> crearReservaSimulada(@PathVariable String id) {
        ReservaDTO nuevaReserva = reservaService.crearReservaSimulada(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }

    @PostMapping
    @Operation(summary = "Guardar una reserva manual", description = "Permite guardar una reserva con datos personalizados.")
    public ResponseEntity<ReservaDTO> guardarReserva(@RequestBody ReservaDTO reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.guardarReserva(reserva));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una reserva existente")
    public ResponseEntity<ReservaDTO> actualizarReserva(@PathVariable String id, @RequestBody ReservaDTO reserva) {
        if (!reservaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        reserva.setId(id);
        ReservaDTO actualizada = reservaService.actualizarReserva(reserva);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reserva por ID")
    public ResponseEntity<Void> eliminarReserva(@PathVariable String id) {
        if (!reservaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        reservaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar reservas por filtros", description = "Permite buscar por usuario, estado, producto y/o fecha.")
    public ResponseEntity<List<ReservaDTO>> buscarReservas(
            @RequestParam(required = false) String usuario,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String producto,
            @RequestParam(required = false) String fecha) {
        List<ReservaDTO> resultado = reservaService.buscarPorFiltros(usuario, estado, producto, fecha);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/codigo/{codigo}")
    @Operation(summary = "Buscar reserva por código")
    public ResponseEntity<ReservaDTO> buscarPorCodigo(@PathVariable String codigo) {
        ReservaDTO reserva = reservaService.buscarPorCodigo(codigo);
        return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }

    @GetMapping("/contar")
    @Operation(summary = "Contar total de reservas")
    public ResponseEntity<Long> contarReservas() {
        return ResponseEntity.ok(reservaService.contarTotal());
    }

    @GetMapping("/contar/estado")
    @Operation(summary = "Contar reservas por estado")
    public ResponseEntity<Long> contarPorEstado(@RequestParam String estado) {
        return ResponseEntity.ok(reservaService.contarPorEstado(estado));
    }
}

