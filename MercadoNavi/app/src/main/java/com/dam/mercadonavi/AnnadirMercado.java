package com.dam.mercadonavi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AnnadirMercado extends AppCompatActivity {

    EditText id_et, nombre_et, ubi_et, fecha_ini_et, fecha_fin_et;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_annadir_mercado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("red")));
        }
        id_et = findViewById(R.id.id_pt);
        nombre_et = findViewById(R.id.nombre_pt);
        ubi_et = findViewById(R.id.ubi_pt);
        fecha_ini_et = findViewById(R.id.fechaIni_pt);
        fecha_fin_et = findViewById(R.id.fechaFin_pt);

    }

    public void Crear(View view) {
        String id = id_et.getText().toString();
        String nombre = nombre_et.getText().toString();
        String ubi = ubi_et.getText().toString();
        String fecha_ini = fecha_ini_et.getText().toString();
        String fecha_fin = fecha_fin_et.getText().toString();

        if (id.isEmpty() || nombre.isEmpty() || ubi.isEmpty() || fecha_ini.isEmpty() || fecha_fin.isEmpty()) {
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.0.2.2/mercado_navideno/crear.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operación exitosa", Toast.LENGTH_SHORT).show();
                // Limpiamos los campos después de insertar
                id_et.setText("");
                nombre_et.setText("");
                ubi_et.setText("");
                fecha_ini_et.setText("");
                fecha_fin_et.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("id", id);
                parametros.put("nombre", nombre);
                parametros.put("ubicacion", ubi);
                parametros.put("fecha_inicio", fecha_ini);
                parametros.put("fecha_fin", fecha_fin);
                return parametros;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void Volver(View view) {
        Intent irMercados = new Intent(this, MainActivity.class);
        startActivity(irMercados);
    }
}
