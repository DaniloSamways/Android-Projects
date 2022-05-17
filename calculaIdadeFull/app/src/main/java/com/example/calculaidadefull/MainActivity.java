package com.example.calculaidadefull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button bCalcula;
    EditText dData;
    TextView tIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bCalcula = findViewById(R.id.bCalcula);
        dData = findViewById(R.id.dData);
        tIdade = findViewById(R.id.tIdade);

    bCalcula.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Calendario c = new Calendario();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            try{
                c.setDatanasc(Calendar.getInstance());
                c.getDatanasc().setTime(sdf.parse(dData.getText().toString()));
                c.Calcula();
                tIdade.setText("Você já viveu "+c.getMes()+" meses, "+c.getDia()+" dias");
            }catch (ParseException e){
                tIdade.setText("Erro de DATA");
            }
        }
    });
    }
}