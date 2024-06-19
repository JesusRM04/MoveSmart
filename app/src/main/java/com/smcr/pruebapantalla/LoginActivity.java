package com.smcr.pruebapantalla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView forgotPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        forgotPasswordTextView = findViewById(R.id.forgot_password);
        Button btnRegistrarse = findViewById(R.id.btn_registrarse);
        // Listener para el botón de iniciar sesión
        loginButton.setOnClickListener(view -> {
            // Lógica para iniciar sesión
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            // Verificación de autenticación puede ir aquí

            // Por ahora, solo redirige a MainActivity
            Intent intent2 = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent2);
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí se maneja el clic del botón "Acceder"
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
                finish(); // Opcionalmente, se puede finalizar esta actividad después de iniciar LoginActivity
            }
        });

        // Listener para el texto de olvidar contraseña
        forgotPasswordTextView.setOnClickListener(view -> {
            // Lógica para recuperar contraseña
        });
    }
}
