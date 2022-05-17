package com.example.calculaidade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button bCalcula;
    EditText tIdade;
    TextView txtViveu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bCalcula = findViewById(R.id.bCalcula);
        tIdade = findViewById(R.id.tIdade);
        txtViveu = findViewById(R.id.txtViveu);

        bCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer idade = Integer.parseInt(tIdade.getText().toString());
                Integer meses = idade*12;
                txtViveu.setText("Já viveu "+meses+" meses");
            }
        });
    }
}