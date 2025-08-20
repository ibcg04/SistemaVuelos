package ec.edu.ec.myapplication;
public class Aeropuerto {
    private String nombre;
    private double latitud;
    private double longitud;

    public Aeropuerto(String nombre, double lat, double lon) {
        this.nombre = nombre;
        this.latitud = lat;
        this.longitud = lon;
    }

    public String getNombre() { return nombre; }
    public double getLatitud() { return latitud; }
    public double getLongitud() { return longitud; }

    @Override
    public String toString() {
        return nombre;
    }
}
