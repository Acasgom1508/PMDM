package com.dam.mercadonavi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listaMercados;
    ArrayList<String> mercados = new ArrayList<>();
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listaMercados = findViewById(R.id.lista_mercados);

        listaMercados.setDividerHeight(5);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("red")));
        }

        JsonArrayRequest jar = new JsonArrayRequest("http://10.0.2.2/mercado_navideno/mostrar_todos.php", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject job = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        job = response.getJSONObject(i);
                        mercados.add(job.getString("nombre"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                listaMercados.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.estilo_lista, mercados));

                listaMercados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position,
                                            long id) {
                        try {
                            String nombreMercadoSeleccionado = (String)
                                    parent.getItemAtPosition(position);
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject mercado = response.getJSONObject(i);
                                if
                                (mercado.getString("nombre").equals(nombreMercadoSeleccionado)) {
                                    int mercadoId = mercado.getInt("id");
//                                  Redirigir al Activity de detalles del mercado
                                    Intent intent = new Intent(MainActivity.this,
                                            MercadoDetalles.class);
                                    intent.putExtra("mercadoId", mercadoId);
                                    startActivity(intent);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Error al cargar el mercado",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_desplegable, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.annadir) {
            Intent irAnnadirMerc = new Intent(this, AnnadirMercado.class);
            startActivity(irAnnadirMerc);
        }
        return super.onOptionsItemSelected(item);
    }
}