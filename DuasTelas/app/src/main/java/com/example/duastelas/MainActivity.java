package com.example.duastelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText tLogin, tSenha;
    Button bLogin;
    CheckBox lembrarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bLogin = findViewById(R.id.bLogin);
        tLogin = findViewById(R.id.tLogin);
        tLogin.setText(lerUser());
        tSenha = findViewById(R.id.tSenha);
        tSenha.setText(lerSenha());
        lembrarSenha = findViewById(R.id.lembrarSenha);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = tLogin.getText().toString();
                String senha = tSenha.getText().toString();
                Boolean lembrar = lembrarSenha.isChecked();

                if(usuario.equals("Dawez") && senha.equals("danilo")){
                    if(lembrar){
                        gravarLogin(usuario, senha);
                    }

                    Intent i = new Intent(MainActivity.this, SegundaActivity.class);
                    i.putExtra("login", usuario);
                    startActivity(i);
                } else{
                    Toast.makeText(MainActivity.this,"Login e/ou senha inválido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void gravarLogin(String usuario, String senha){
        try{
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("gravarLogin.txt", Context.MODE_PRIVATE));
            osw.write(senha+'\n');
            osw.write(usuario);
            osw.close();
        }catch(IOException e){
            Log.v("MainActivity", e.getMessage());
        }
    }

    private String lerUser(){
        String user = "";
        try{
            InputStream arq = openFileInput("gravarLogin.txt");
            if(arq!=null){
                InputStreamReader isr = new InputStreamReader(arq);
                BufferedReader bis = new BufferedReader(isr);
                bis.readLine();
                user = bis.readLine();
                arq.close();
            }
        }catch(IOException e){
            Log.v("MainActivity", e.getMessage());
        }
        return user;
    }

    private String lerSenha(){
        String senha = "";
        try{
            InputStream arq = openFileInput("gravarLogin.txt");
            if(arq!=null){
                InputStreamReader isr = new InputStreamReader(arq);
                BufferedReader bis = new BufferedReader(isr);
                senha = bis.readLine();
                arq.close();
            }
        }catch(IOException e){
            Log.v("MainActivity", e.getMessage());
        }
        return senha;
    }
}