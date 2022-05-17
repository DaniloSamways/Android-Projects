package com.example.dado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button bSorteia;
    ImageView iDado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bSorteia = findViewById(R.id.bSortear);
        iDado = findViewById(R.id.iDado);

        bSorteia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = "dado";
                int sorteia = new Random().nextInt(6);
                sorteia += 1;
                fileName = fileName.concat(String.valueOf(sorteia));
                iDado.setImageResource(getResources().getIdentifier(fileName, "drawable", getPackageName()));
            }
        });
    }
}