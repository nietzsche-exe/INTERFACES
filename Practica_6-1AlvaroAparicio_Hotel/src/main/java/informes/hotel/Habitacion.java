package informes.hotel;

public class Habitacion {
    private Integer num_habitacion;
    private Double precio;
    private Reserva reserva;

    public Habitacion(Integer num_habitacion, Double precio, Reserva reserva) {
        this.num_habitacion = num_habitacion;
        this.precio = precio;
        this.reserva = reserva;
    }

    public Integer getNum_habitacion() {
        return num_habitacion;
    }
    public void setNum_habitacion(Integer num_habitacion) {
        this.num_habitacion = num_habitacion;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

}
