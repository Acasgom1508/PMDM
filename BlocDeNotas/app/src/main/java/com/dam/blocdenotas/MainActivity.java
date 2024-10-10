package com.dam.blocdenotas;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText etMulti;

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
        etMulti = findViewById(R.id.et_multi);
        String archivos [] = fileList();
        if(archivoExiste(archivos, "blocdenotas.txt")){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("blocdenotas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String notaCompleta = "";
            } catch (IOException e){

            }
        }
    }


}