package com.example.calculapeso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bVerifica;
    TextView nPeso;
    TextView nAltura;
    ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bVerifica = findViewById(R.id.bVerifica);
        nPeso = findViewById(R.id.nPeso);
        nAltura = findViewById(R.id.nAltura);
        imagem = findViewById(R.id.imagem);



        bVerifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double peso = Double.parseDouble(nPeso.getText().toString());
                Double altura = Double.parseDouble(nAltura.getText().toString());

                Double imc = peso / (altura * altura);
                if(imc > 26){
                    imagem.setImageResource(R.drawable.gordo);
                }else{
                    imagem.setImageResource(R.drawable.magro);
                }
            }
        });
    }
}