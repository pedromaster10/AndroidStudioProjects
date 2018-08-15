package com.packtputb.mathgamechapter2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends Activity implements View.OnClickListener{

    int correctAnswer;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Here we initialize all our variables
        int partA = 2;
        int partB = 2;
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer -1;
        int wrongAnswer2 = correctAnswer +1;

        //Aqui sao criados e inicializadas variaveis dos tipos
        // textview e button para que sejam linkados com os elementos
        //que irão aparecer na tela.

        TextView textObjectPartA = (TextView)findViewById(R.id.textPartA);
        TextView textObjectPartB = (TextView)findViewById(R.id.textPartB);
        buttonObjectChoice1 = (Button)findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button)findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button)findViewById(R.id.buttonChoice3);

        //Agora o metodo setText da classe é usado para mostrar os valores
        //das nossas variaveis nos elementos da interface grafica do app.

        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);

        //Qual objeto recebe qual resposta nesse momento nao importa.

        buttonObjectChoice1.setText("" + correctAnswer);
        buttonObjectChoice2.setText("" + wrongAnswer1);
        buttonObjectChoice3.setText("" + wrongAnswer2);


        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //um novo int é declarado para ser usado em todos os cases
        int answerGiven=0;
        switch (view.getId()){

            case R.id.buttonChoice1:
                //inicializa a nova variavel int com o valor contido em //buttonObjectChoice1
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());

                //essa é a resposta correta?
                if(answerGiven==correctAnswer) {//yay it's the right answer
                    Toast.makeText(getApplicationContext(), "Parabens, acertou!", Toast.LENGTH_LONG).show();
                }else{//ops...
                    Toast.makeText(getApplicationContext(), "Eu sinto muito, esta errado!", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.buttonChoice2:
                //inicializa a nova variavel int com o valor contido em //buttonObjectChoice2
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());

                //essa é a resposta correta?
                if(answerGiven==correctAnswer) {//yay it's the right answer
                    Toast.makeText(getApplicationContext(), "Parabens, acertou!", Toast.LENGTH_LONG).show();
                }else{//ops...
                    Toast.makeText(getApplicationContext(), "Eu sinto muito, esta errado!", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.buttonChoice3:
                //inicializa a nova variavel int com o valor contido em //buttonObjectChoice3
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());

                //essa é a resposta correta?
                if(answerGiven==correctAnswer) {//yay it's the right answer
                    Toast.makeText(getApplicationContext(), "Parabens, acertou!", Toast.LENGTH_LONG).show();
                }else{//ops...
                    Toast.makeText(getApplicationContext(), "Eu sinto muito, esta errado!", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
