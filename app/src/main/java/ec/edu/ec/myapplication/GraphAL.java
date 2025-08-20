package ec.edu.ec.myapplication;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphAL<Aeropuerto, String> {
   private LinkedList<Vertex<Aeropuerto, String>> vertices;
   private boolean isDirected;
   private Comparator<Aeropuerto> cmp;

    public GraphAL() {
        this.isDirected = isDirected;
        this.cmp = cmp;
    }
    public LinkedList<Vertex<Aeropuerto, String>> getVertices(){
        return vertices;
    }
     public Vertex<Aeropuerto, String> findVertex(Aeropuerto content) {
        if (content == null) return null;
        if (vertices.isEmpty()) return null;
        
        Iterator<Vertex<Aeropuerto, String>> it = vertices.iterator();
        while (it.hasNext()) {
            Vertex<Aeropuerto, String> vertice = it.next();
            if (this.cmp.compare(content, vertice.getContent()) == 0) {
                return vertice;
            }
        }
        return null;
    }
    
    public boolean addVertex(Aeropuerto content) {
        if (content == null || findVertex(content) == null) return false;
        
        Vertex<Aeropuerto, String> vertice = new Vertex<>(content);
        this.vertices.add(vertice);
        
        return true;
    }

    public boolean connect(Aeropuerto content1, Aeropuerto content2, int weight, String data){
        if (content1==null || content2==null) return false;

        Vertex<Aeropuerto, String> v1= findVertex(content1);
        Vertex<Aeropuerto, String> v2= findVertex(content2);

        if (v1 == null || v2 == null){
            return false;
        }
        Vuelo<Aeropuerto, String > nuevasAristas = new Vuelo<>(v1, v2, weight, data);
        v1.getEdges().add(nuevasAristas);

        if (!this.isDirected){
            Vuelo<Aeropuerto, String > reverseEdge = new Vuelo<>(v2, v1, weight, data);
            v2.getEdges().add(reverseEdge);
        }

        return true;
    }
}