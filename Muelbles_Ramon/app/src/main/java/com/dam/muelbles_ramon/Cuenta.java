package com.dam.muelbles_ramon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cuenta extends AppCompatActivity {

    private TextView nombreCuenta_tv;
    private EditText nombre_et;
    private EditText email_et;
    private EditText dir_et;
    private EditText cntr_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuenta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombre_et = findViewById(R.id.nombre_et);
        email_et = findViewById(R.id.email_et);
        dir_et = findViewById(R.id.dir_et);
        cntr_et = findViewById(R.id.cntr_et);
        nombreCuenta_tv = findViewById(R.id.nombreCuenta_tv);

        SharedPreferences datosUsuario = getSharedPreferences("DatosUsuario", MODE_PRIVATE);

        String nombreUsuario = datosUsuario.getString("nombreUsuario", "");  // Si es nulo, retorna ""
        String email = datosUsuario.getString("email", "");
        String direccion = datosUsuario.getString("direccion", "");
        String contrasena = datosUsuario.getString("contrasena", "");

        nombre_et.setText(nombreUsuario);
        email_et.setText(email);
        dir_et.setText(direccion);
        cntr_et.setText(contrasena);

        nombreCuenta_tv.setText(nombreUsuario);

    }

    public void irAtras(View view) {
        finish();
    }

    public void guardarCambios(View view) {
        String nombreUsuario = nombre_et.getText().toString();
        String email = email_et.getText().toString();
        String direccion = dir_et.getText().toString();
        String contrasena = cntr_et.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("DatosUsuario", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nombreUsuario", nombreUsuario);
        editor.putString("email", email);
        editor.putString("direccion", direccion);
        editor.putString("contrasena", contrasena);

        editor.apply();

        Toast.makeText(this, "Cambios guardados", Toast.LENGTH_SHORT).show();
    }

}