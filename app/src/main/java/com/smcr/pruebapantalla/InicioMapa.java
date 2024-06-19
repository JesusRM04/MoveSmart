package com.smcr.pruebapantalla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class InicioMapa extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_mapa);

        // Acceder a los elementos del layout
        ImageView backgroundImg = findViewById(R.id.background_image);
        TextView title1 = findViewById(R.id.move_smart_title);
        EditText searchEditText = findViewById(R.id.search);

        // Ejemplo de configuración de propiedades
        title1.setText("MOVE SMART"); // Cambiar el texto del TextView
        searchEditText.setHint("Buscar..."); // Cambiar el hint del EditText
        backgroundImg.setImageResource(R.drawable.fondo); // Cambiar la imagen de fondo del ImageView

        // Añadir OnClickListener al EditText para redirigir a InicioBusqueda
        searchEditText.setOnClickListener(v -> {
            Intent intent = new Intent(InicioMapa.this, InicioBusqueda.class);
            startActivity(intent);
        });

        // Inicializar el fragmento de mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        // Cargar el mapa asincrónicamente
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Configurar el mapa centrado en Aguascalientes
        LatLng aguascalientes = new LatLng(21.8853, -102.2916);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aguascalientes, 12));
    }
}
