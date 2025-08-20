package ec.edu.ec.myapplication;

public class Vuelo<Aeropuerto, String> {
    private Vertex<Aeropuerto, String> origen;
    private Vertex<Aeropuerto, String> destino;
    private int peso;
    private String data;

    public Vuelo(Vertex<Aeropuerto, String> source, Vertex<Aeropuerto, String> target, int peso, String data) {
        this.origen = source;
        this.destino = target;
        this.peso = peso;
        this.data = data;
    }

    public Vuelo(Vertex<Aeropuerto, String> source, Vertex<Aeropuerto, String> target, int weight) {
        this (source, target, weight, null);
    }

    public Vuelo(Vertex<Aeropuerto, String> source, Vertex<Aeropuerto, String> target, String data) {
        this (source, target, -1, data);
    }

    public Vuelo(Vertex<Aeropuerto, String> source, Vertex<Aeropuerto, String> target) {
        this (source, target, -1, null);
    }

    public Vertex<Aeropuerto, String> getOrigen() {
        return origen;
    }

    public void setorigen(Vertex<Aeropuerto, String> source) {
        this.origen = source;
    }

    public Vertex<Aeropuerto, String> getDestino() {
        return destino;
    }

    public void setDestino(Vertex<Aeropuerto, String> target) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int weight) {
        this.peso = weight;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}