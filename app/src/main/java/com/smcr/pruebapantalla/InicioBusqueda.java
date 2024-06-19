package com.smcr.pruebapantalla;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InicioBusqueda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_busqueda);

        // Acceder a los elementos del layout
        ImageView backgroundImg = findViewById(R.id.background_image);
        TextView title1 = findViewById(R.id.move_smart_title);
        TextView title2 = findViewById(R.id.move_smart_title2);
        EditText searchEditText = findViewById(R.id.search);
        EditText rutaEditText = findViewById(R.id.ruta);
        Button elegirMapaButton = findViewById(R.id.elegirMapa);

        // Ejemplo de configuración de propiedades
        title1.setText("MOVE SMART"); // Cambiar el texto del TextView
        title2.setText("¿A dónde quieres ir?"); // Cambiar el texto del TextView
        searchEditText.setHint("Buscar..."); // Cambiar el hint del EditText
        rutaEditText.setHint("   Buscar una ruta"); // Cambiar el hint del EditText
        backgroundImg.setImageResource(R.drawable.fondo); // Cambiar la imagen de fondo del ImageView

        // Configurar el botón "Elegir en el mapa"
        elegirMapaButton.setText("Elegir en el mapa");

        // Añadir OnClickListener al botón para volver a InicioMapa
        elegirMapaButton.setOnClickListener(v -> {
            Intent intent = new Intent(InicioBusqueda.this, InicioMapa.class);
            startActivity(intent);
        });
    }
}
