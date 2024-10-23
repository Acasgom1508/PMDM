package com.dam.muelbles_ramon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Carrito extends AppCompatActivity {

    ArrayList<String> carrito = new ArrayList<>();
    ArrayList<Integer> precios = new ArrayList<>();
    private ListView lista;
    private TextView totalTextView;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_carrito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lista = findViewById(R.id.lista_carrito);
        totalTextView = findViewById(R.id.total_txt); // Asegúrate de tener un TextView para mostrar el total

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, carrito);
        lista.setAdapter(adapter);

        // Obtener los datos pasados de las activities Mesas o Sillas
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("nombreMueble") && intent.hasExtra("precioMueble")) {
            String nombreMueble = intent.getStringExtra("nombreMueble");
            int precioMueble = intent.getIntExtra("precioMueble", 0);

            carrito.add(nombreMueble + ": " + precioMueble + "€");
            precios.add(precioMueble);
            total += precioMueble;

            adapter.notifyDataSetChanged();
            totalTextView.setText(total + "€");
        }
    }

    public void irAtras(View view) {
        finish();
    }

    public void comprar(View view) {
        carrito.clear();
        precios.clear();
        total = 0;

        ArrayAdapter adapter = (ArrayAdapter) lista.getAdapter();
        adapter.notifyDataSetChanged();
        totalTextView.setText(total + "€");

        Toast.makeText(this, "Compra realizada", Toast.LENGTH_SHORT).show();
    }
}
