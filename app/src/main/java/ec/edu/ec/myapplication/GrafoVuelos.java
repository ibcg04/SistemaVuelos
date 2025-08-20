package ec.edu.ec.myapplication;
import java.util.*;

public class GrafoVuelos {
    private GraphAL<Aeropuerto, String> grafo;

    public GrafoVuelos() {
        grafo = new GraphAL<>();
    }

    public void agregarAeropuerto(Aeropuerto a) {
        grafo.addVertex(a);
    }

    public void agregarVuelo(Aeropuerto origen, Aeropuerto destino, int kmDistancia) {
        Vertex<Aeropuerto, String> vOrigen = grafo.findVertex(origen);
        Vertex<Aeropuerto, String> vDestino = grafo.findVertex(destino);
        if (vOrigen != null && vDestino != null) {
            String etiqueta = kmDistancia + " km"; // representación en String
            grafo.connect(origen, destino, kmDistancia, etiqueta);
        }
    }

    public LinkedList<Aeropuerto> getAeropuertos() {
        LinkedList<Aeropuerto> lista = new LinkedList<>();
        for (Vertex<Aeropuerto, String> v : grafo.getVertices()) {
            lista.add(v.getAeropuerto());
        }
        return lista;
    }

    public LinkedList<Vuelo<Aeropuerto, String>> getVuelos() {
        LinkedList<Vuelo<Aeropuerto, String>> vuelos = new LinkedList<>();
        for (Vertex<Aeropuerto, String> v : grafo.getVertices()) {
            vuelos.addAll(v.getEdges());
        }
        return vuelos;
    }

    // Algoritmo de Dijkstra
    public LinkedList<Aeropuerto> dijkstra(Aeropuerto origen, Aeropuerto destino) {
        Map<Vertex<Aeropuerto, String>, Integer> dist = new HashMap<>();
        Map<Vertex<Aeropuerto, String>, Vertex<Aeropuerto, String>> prev = new HashMap<>();
        Set<Vertex<Aeropuerto, String>> visitados = new HashSet<>();

        Vertex<Aeropuerto, String> vOrigen = grafo.findVertex(origen);
        Vertex<Aeropuerto, String> vDestino = grafo.findVertex(destino);
        if (vOrigen == null || vDestino == null) return new LinkedList<>();

        // Inicialización
        for (Vertex<Aeropuerto, String> v : grafo.getVertices()) {
            dist.put(v, Integer.MAX_VALUE);
            prev.put(v, null);
        }
        dist.put(vOrigen, 0);

        PriorityQueue<Vertex<Aeropuerto, String>> pq =
                new PriorityQueue<>(Comparator.comparingInt(dist::get));
        pq.add(vOrigen);

        // Bucle principal
        while (!pq.isEmpty()) {
            Vertex<Aeropuerto, String> u = pq.poll();
            if (!visitados.add(u)) continue;
            if (u == vDestino) break;

            for (Vuelo<Aeropuerto, String> e : u.getEdges()) {
                Vertex<Aeropuerto, String> v = e.getDestino();
                int w = e.getPeso();
                int du = dist.get(u);
                if (du != Integer.MAX_VALUE) {
                    int alt = du + w;
                    if (alt < dist.get(v)) {
                        dist.put(v, alt);
                        prev.put(v, u);
                        pq.add(v);
                    }
                }
            }
        }

        if (dist.get(vDestino) == Integer.MAX_VALUE) return new LinkedList();

        LinkedList<Aeropuerto> ruta = new LinkedList<>();
        for (Vertex<Aeropuerto, String> paso = vDestino; paso != null; paso = prev.get(paso)) {
            ruta.addFirst(paso.getAeropuerto());
        }
        return ruta;
    }




}

