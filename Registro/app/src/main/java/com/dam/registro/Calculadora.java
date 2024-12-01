package com.dam.registro;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculadora extends AppCompatActivity {

    Button numero1, numero2, numero3, numero4, numero5, numero6, numero7, numero8, numero9, numero0, suma, resta, multiplicacion, division, igual;
    TextView numeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numeros = findViewById(R.id.numeros);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        numero3 = findViewById(R.id.numero3);
        numero4 = findViewById(R.id.numero4);
        numero5 = findViewById(R.id.numero5);
        numero6 = findViewById(R.id.numero6);
        numero7 = findViewById(R.id.numero7);
        numero8 = findViewById(R.id.numero8);
        numero9 = findViewById(R.id.numero9);
        numero0 = findViewById(R.id.numero0);
        suma = findViewById(R.id.botonSuma);
        resta = findViewById(R.id.botonRestar);
        multiplicacion = findViewById(R.id.botonMult);
        division = findViewById(R.id.botonDiv);
        igual = findViewById(R.id.botonIgual);

        numero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("1");
            }
        });

        numero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("2");
            }
        });

        numero3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("3");
            }
        });

        numero4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("4");
            }
        });

        numero5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("5");
            }
        });

        numero6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("6");
            }
        });

        numero7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("7");
            }
        });

        numero8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("8");
            }
        });

        numero9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("9");
            }
        });

        numero0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeros.append("0");
            }
        });


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.mipmap.logo_app);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#388E3C")));
        }


    }

    public void volver(View view) {
        finish();
    }

    public void irScroll(View view) {
        startActivity(new Intent(this, pruebaScroll.class));
    }
}