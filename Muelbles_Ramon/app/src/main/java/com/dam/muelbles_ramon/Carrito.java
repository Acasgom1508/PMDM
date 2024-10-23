package com.dam.muelbles_ramon;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Carrito extends AppCompatActivity {

    ArrayList carrito = new ArrayList();
    private ListView lista;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carrito);
        lista.setAdapter(adapter);
    }

    public void irAtras(View view) {
        finish();
    }

    public void comprar(View view) {
        carrito.clear();
        ArrayAdapter adapter = (ArrayAdapter) lista.getAdapter();  // Obténer el adaptador actual
        adapter.notifyDataSetChanged();  // Notifica al adaptador que los datos han cambiado
        Toast.makeText(this, "Compra realizada", Toast.LENGTH_SHORT).show();
    }


}