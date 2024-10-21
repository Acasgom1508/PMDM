package com.dam.muelbles_ramon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bienvenida extends AppCompatActivity {

    private EditText usuario_pt, contra_pt;
    private SharedPreferences usu_pref,cont_pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bienvenida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usuario_pt = findViewById(R.id.usuario_pt);
        contra_pt = findViewById(R.id.contra_pt);

        usu_pref = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        cont_pref = getSharedPreferences("contrasena", Context.MODE_PRIVATE);

        usuario_pt.setText(usu_pref.getString("usuario", ""));
        contra_pt.setText(cont_pref.getString("contrasena", ""));

    }

    public void iniciarSesion(View view) {
        usu_pref = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        cont_pref = getSharedPreferences("contrasena", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor_usu = usu_pref.edit();
        SharedPreferences.Editor editor_cont = cont_pref.edit();

        editor_usu.putString("usuario", usuario_pt.getText().toString());
        editor_cont.putString("contrasena", usuario_pt.getText().toString());

        editor_usu.apply();
        editor_cont.apply();

        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
        Intent nuevaPantalla = new Intent(this, inicio.class);
        startActivity(nuevaPantalla);
    }
}