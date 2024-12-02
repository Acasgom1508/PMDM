package com.dam.mercadonavi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MercadoDetalles extends AppCompatActivity {

    TextView id_tv, nombre_tv, ubi_tv, fecha_ini_tv, fecha_fin_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mercado_detalles);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        id_tv = findViewById(R.id.id_tv);
        nombre_tv = findViewById(R.id.nombre_tv);
        ubi_tv = findViewById(R.id.ubi_tv);
        fecha_ini_tv = findViewById(R.id.fechaIni_tv);
        fecha_fin_tv = findViewById(R.id.fechaFin_tv);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String id = extras.getString("id");
            String nombre = extras.getString("nombre");
            String ubi = extras.getString("ubi");
            String fecha_ini = extras.getString("fecha_ini");
            String fecha_fin = extras.getString("fecha_fin");
        }

    }
}