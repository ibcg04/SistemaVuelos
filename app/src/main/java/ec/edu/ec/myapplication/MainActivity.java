package ec.edu.ec.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MapView map;
    private GrafoVuelos grafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_main);

        map = findViewById(R.id.map);
        map.setMultiTouchControls(true);

        grafo = new GrafoVuelos();
        cargarDatosIniciales();

        mostrarAeropuertos();
        mostrarVuelos();

        // Ejemplo: ruta más corta Daxing -> Heathrow
        Aeropuerto dax = grafo.getAeropuertos().get(0);
        Aeropuerto heath = grafo.getAeropuertos().get(1);
        mostrarRutaCorta(dax, heath);
    }

    private void cargarDatosIniciales() {
        Aeropuerto daxing = new Aeropuerto("Daxing", 39.5098, 116.4109);
        Aeropuerto heathrow = new Aeropuerto("Heathrow", 51.4700, -0.4543);
        Aeropuerto jfk = new Aeropuerto("JFK", 40.6413, -73.7781);

        grafo.agregarAeropuerto(daxing);
        grafo.agregarAeropuerto(heathrow);
        grafo.agregarAeropuerto(jfk);

        grafo.agregarVuelo(daxing, heathrow, 8200);
        grafo.agregarVuelo(daxing, jfk, 11000);
        grafo.agregarVuelo(jfk, heathrow, 5560);
    }

    private void mostrarAeropuertos() {
        for (Aeropuerto a : grafo.getAeropuertos()) {
            GeoPoint punto = new GeoPoint(a.getLat(), a.getLon());
            Marker marker = new Marker(map);
            marker.setPosition(punto);
            marker.setTitle(a.getNombre());
            map.getOverlays().add(marker);
        }
        map.getController().setZoom(3.0);
        map.getController().setCenter(new GeoPoint(39.5098, 116.4109)); // Daxing
    }

    private void mostrarVuelos() {
        for (Vuelo v : grafo.getVuelos()) {
            GeoPoint origen = new GeoPoint(v.getOrigen().getContent().getLat(), v.getOrigen().getContent().getLon());
            GeoPoint destino = new GeoPoint(v.getDestino().getContent().getLat(), v.getDestino().getContent().getLon());

            Polyline line = new Polyline();
            line.addPoint(origen);
            line.addPoint(destino);
            line.setWidth(3f);
            line.setColor(0x550000FF); // Azul semitransparente
            map.getOverlayManager().add(line);
        }
    }

    private void mostrarRutaCorta(Aeropuerto origen, Aeropuerto destino) {
        List<Aeropuerto> ruta = grafo.dijkstra(origen, destino);
        if (!ruta.isEmpty()) {
            Polyline polyline = new Polyline();
            for (Aeropuerto a : ruta) {
                polyline.addPoint(new GeoPoint(a.getLat(), a.getLon()));
            }
            polyline.setWidth(6f);
            polyline.setColor(0xFFFF0000); // Rojo
            map.getOverlayManager().add(polyline);
        }
    }
}
