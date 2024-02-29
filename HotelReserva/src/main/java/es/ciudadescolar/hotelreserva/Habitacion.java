package es.ciudadescolar.hotelreserva;

/**
 * Clase que representa una habitación en un hotel.
 * @version 1.0
 * @since 2023-2024
 * @author Jose Julian Saavedra
 */
public class Habitacion {
    private Integer id_habitacion;
    private Double precio;
    private Reserva reserva;

    /**
     * Constructor de la clase Habitacion.
     * @param id_habitacion Identificador de la habitación.
     * @param precio Precio de la habitación.
     * @param reserva Reserva asociada a la habitación.
     */
    public Habitacion(Integer id_habitacion, Double precio, Reserva reserva) {
        this.id_habitacion = id_habitacion;
        this.precio = precio;
        this.reserva = reserva;
    }

    /**
     * Método para obtener el identificador de la habitación.
     * @return El identificador de la habitación.
     */
    public Integer getId_habitacion() {
        return id_habitacion;
    }

    /**
     * Método para establecer el identificador de la habitación.
     * @param id_habitacion El identificador de la habitación.
     */
    public void setId_habitacion(Integer id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    /**
     * Método para obtener el precio de la habitación.
     * @return El precio de la habitación.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Método para establecer el precio de la habitación.
     * @param precio El precio de la habitación.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Método para obtener la reserva asociada a la habitación.
     * @return La reserva asociada a la habitación.
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * Método para establecer la reserva asociada a la habitación.
     * @param reserva La reserva asociada a la habitación.
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
