package ec.edu.ec.myapplication;

import java.util.LinkedList;

public class Vertex<Aeropuerto, String> {
    private Aeropuerto aeropuerto;
    private LinkedList<Vuelo<Aeropuerto, String>> edges;

    public Vertex(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
        this.edges = new LinkedList<>();
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setContent(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public LinkedList<Vuelo<Aeropuerto,String >> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Vuelo< Aeropuerto,String >> edges) {
        this.edges = edges;
    }

}
