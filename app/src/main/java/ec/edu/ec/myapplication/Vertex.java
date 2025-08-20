package ec.edu.ec.myapplication;

import java.util.LinkedList;

public class Vertex<Aeropuerto, String> {
    private Aeropuerto content;
    private LinkedList<Vuelo<Aeropuerto, String>> edges;

    public Vertex(Aeropuerto content) {
        this.content = content;
        this.edges = new LinkedList<>();
    }

    public Aeropuerto getContent() {
        return content;
    }

    public void setContent(Aeropuerto content) {
        this.content = content;
    }

    public LinkedList<Vuelo<Aeropuerto,String >> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Vuelo< Aeropuerto,String >> edges) {
        this.edges = edges;
    }
      
}
