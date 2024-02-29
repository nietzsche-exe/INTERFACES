package es.ciudadescolar.hotelreserva;

/**
 * Clase que representa una reserva de habitación en un hotel.
 * @version 1.0
 * @since 2023-2024
 * @author Jose Julian Saavedra
 */
public class Reserva {
    private Integer num_personas;
    private String nombre;
    private String apellidos;
    private Integer num_noches;

    /**
     * Constructor de la clase Reserva.
     * @param num_personas Número de personas en la reserva.
     * @param nombre Nombre del titular de la reserva.
     * @param apellidos Apellidos del titular de la reserva.
     * @param num_noches Número de noches de la reserva.
     */
    public Reserva(Integer num_personas, String nombre, String apellidos, Integer num_noches) {
        this.num_personas = num_personas;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.num_noches = num_noches;
    }

    /**
     * Método para obtener el número de personas en la reserva.
     * @return El número de personas en la reserva.
     */
    public Integer getNum_personas() {
        return num_personas;
    }

    /**
     * Método para establecer el número de personas en la reserva.
     * @param num_personas El número de personas en la reserva.
     */
    public void setNum_personas(Integer numPersonas) {
        this.num_personas = num_personas;
    }

    /**
     * Método para obtener el nombre del titular de la reserva.
     * @return El nombre del titular de la reserva.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del titular de la reserva.
     * @param nombre El nombre del titular de la reserva.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener los apellidos del titular de la reserva.
     * @return Los apellidos del titular de la reserva.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método para establecer los apellidos del titular de la reserva.
     * @param apellidos Los apellidos del titular de la reserva.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método para obtener el número de noches de la reserva.
     * @return El número de noches de la reserva.
     */
    public Integer getNum_noches() {
        return num_noches;
    }

    /**
     * Método para establecer el número de noches de la reserva.
     * @param num_noches El número de noches de la reserva.
     */
    public void setNum_noches(Integer num_noches) {
        this.num_noches = num_noches;
    }
}
