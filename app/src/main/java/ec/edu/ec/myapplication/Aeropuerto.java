package ec.edu.ec.myapplication;
public class Aeropuerto {
    private String nombre;
    private double lat;
    private double lon;

    public Aeropuerto(String nombre, double lat, double lon) {
        this.nombre = nombre;
        this.lat = lat;
        this.lon = lon;
    }

    public String getNombre() { return nombre; }
    public double getLat() { return lat; }
    public double getLon() { return lon; }

    @Override
    public String toString() {
        return nombre;
    }
}
