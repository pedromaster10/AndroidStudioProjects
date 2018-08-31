package com.packtpub.arraysexemple;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Um objeto aleatório para gerar numeros para questoes depois
        Random randInt = new Random();
        //E uma variavel para guardar o valor aleatorio gerado
        int questionNumber;

        //Aqui sao declarados e alocados separadamente
        String[][] countriesAndCities;
        //Aqui nós temos 2 arrays unidimensionais

        countriesAndCities = new String[5][2];

        //agora nós carregamos os arreis com cada Pais
        countriesAndCities [0][0] = "United Kingdom";
        countriesAndCities [0][1] = "London";

        countriesAndCities [1][0] = "USA";
        countriesAndCities [1][1] = "Washington";

        countriesAndCities [2][0] = "India";
        countriesAndCities [2][1] = "New Delhi";

        countriesAndCities [3][0] = "Brazil";
        countriesAndCities [3][1] = "Brasilia";

        countriesAndCities [4][0] = "Kenya";
        countriesAndCities [4][1] = "Nairobi";

        //Agora nós sabemmos que cada Pais esta no elemento 0
        //E cada capital esta no elemento 1

        //essas duas variaveis refletem isto
        int country = 0;
        int capital = 1;

        //Um pequeno loop para fazer 3 questoes
        for (int i = 0; i < 3; i++){
            //cria um numero de questao aleatorio entre 0 e 4
            questionNumber = randInt.nextInt(5);

            //A seguir realiza a pergunta e logo
            //entrega a resposta por uma questao de brevidade
            Log.i("info", "the capital of " +countriesAndCities[questionNumber][country]);

            Log.i("info", "is " +countriesAndCities[questionNumber][capital]);
        }//fim do loop
    }
}
