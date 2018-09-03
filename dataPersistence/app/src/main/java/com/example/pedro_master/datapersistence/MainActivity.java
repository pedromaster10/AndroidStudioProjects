package com.example.pedro_master.datapersistence;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener{

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String dataName = "MyData";
    String stringName = "MyString";
    String defaultString = ":-(";
    String currentString = "";//vazio
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializa nossos dois SharedPreferences objects
        prefs = getSharedPreferences(dataName, MODE_PRIVATE);
        editor = prefs.edit();

        //carrega um nome para nossa string e
        //um valor padrão
        currentString = prefs.getString(stringName, defaultString);

        //Linka a variavel button1 ao botão do layout
        button1 =(Button) findViewById(R.id.button);

        //Faz com que o botão "ouça" os cliques
        button1.setOnClickListener(this);

        //carrega currentString no botão
        button1.setText(currentString);

    }

    @Override
    public void onClick(View view) {

        //Nada de switch aqui, visto que só tem um botão

        //Gera um numero aleatorio entre 0 e 9
        Random randInt = new Random();
        int ourRandom = randInt.nextInt(10);

        currentString = currentString + ourRandom;

        //Salva currentString em um arquivo no caso
        //de o usuario eventualmente sair ou rece-
        //ber uma ligação
        editor.putString(stringName, currentString);
        editor.commit();

        //atualiza o button text
        button1.setText(currentString);
    }
}