package informes.hotel;


public class Reserva {

    private Integer num_personas;
    private String nombre;
    private String apellido;
    private Integer tiempo;

    public Reserva(Integer num_personas, String nombre, String apellido, Integer tiempo) {
        this.num_personas = num_personas;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tiempo = tiempo;
    }

    public Integer getNum_personas() {
        return num_personas;
    }
    public void setNum_personas(Integer num_personas) {
        this.num_personas = num_personas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getTiempo() {
        return tiempo;
    }
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }
}
