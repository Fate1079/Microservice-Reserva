package com.example.MicroService_Reserva.Domian.DTO;




public class ReservaDTO {

    private String id;
    private String codigo;
    private String usuario;
    private String producto;
    private String precio;
    private String estado;
    private String fechaInicio;
    private String fechaFinal;
    private String avion;


    // Constructor vacío
    public ReservaDTO() {}

    // Constructor que simula datos
    public ReservaDTO(String id) {
        this.id = id;
        simularDatos();
    }

    /**
     * Simula fechas de inicio y final
     */
    private void simularFechas() {
        // Fechas de inicio (próximos días)
        String[] fechasInicio = {
                "2025-09-05 15:00",
                "2025-09-12 19:00",
                "2025-09-20 08:00",
                "2025-09-08 14:00",
                "2025-09-15 10:00"
        };

        // Fechas finales (según el servicio)
        String[] fechasFinales = {
                "2025-09-07 12:00",  // 2 noches hotel
                "2025-09-12 22:00",  // Cena restaurante (mismo día)
                "2025-09-20 18:00",  // Evento 1 día
                "2025-09-09 12:00",  // 1 noche hotel
                "2025-09-15 14:00"   // Spa 4 horas
        };

        String[] aviones = {
                "Avianca - Vuelo AV123",
                "LATAM - Vuelo LA456",
                "Copa Airlines - Vuelo CM789",
                "Viva Air - Vuelo VV321",
                "Wingo - Vuelo WG654"
        };


        int index = Math.abs(id.hashCode()) % fechasInicio.length;
        this.avion = aviones[index];
        this.fechaInicio = fechasInicio[index];
        this.fechaFinal = fechasFinales[index];
    }

    /**
     * Simula todos los datos de la reserva
     */
    private void simularDatos() {
        // Usuarios simulados
        String[] usuarios = {
                "María González - maria@email.com",
                "Carlos Rodríguez - carlos@gmail.com",
                "Ana Martínez - ana@hotmail.com",
                "Luis Hernández - luis@empresa.com",
                "Carmen López - carmen@yahoo.com"
        };

        // Productos simulados
        String[] productos = {
                "Habitación Doble - 2 noches",
                "Mesa Restaurante - 8 personas",
                "Salón Eventos - 1 día",
                "Suite Premium - 1 noche",
                "Spa Completo - 4 horas"
        };

        // Precios simulados
        String[] precios = {
                "$250.000 COP",
                "$320.000 COP",
                "$1.200.000 COP",
                "$450.000 COP",
                "$180.000 COP"
        };

        // Estados simulados
        String[] estados = {"PENDIENTE", "CONFIRMADA", "CANCELADA", "COMPLETADA"};

        // Seleccionar datos basado en el ID
        int index = Math.abs(id.hashCode()) % usuarios.length;

        this.codigo = "RSV-2025-" + String.format("%03d", Integer.parseInt(id));
        this.usuario = usuarios[index];
        this.producto = productos[index];
        this.precio = precios[index];
        this.estado = estados[index % estados.length];

        // Simular fechas
        simularFechas();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }

    public String getPrecio() { return precio; }
    public void setPrecio(String precio) { this.precio = precio; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFinal() { return fechaFinal; }
    public void setFechaFinal(String fechaFinal) { this.fechaFinal = fechaFinal; }

    public String getAvion() { return avion; }
    public void setAvion(String avion) { this.avion = avion; }

    @Override
    public String toString() {
        return "ReservaDTO{" +
                "id='" + id + '\'' +
                ", codigo='" + codigo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", producto='" + producto + '\'' +
                ", precio='" + precio + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFinal='" + fechaFinal + '\'' +
                '}';
    }
}