package com.packtputb.mathgamechapter2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class GameActivity extends Activity implements View.OnClickListener{

    int correctAnswer;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textObjectScore;
    TextView textObjectLevel;

    int currentScore = 0;
    int currentLevel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Aqui sao criados e inicializadas variaveis dos tipos
        // textview e button para que sejam linkados com os elementos
        //que irão aparecer na tela.

        textObjectPartA = (TextView)findViewById(R.id.textPartA);
        textObjectPartB = (TextView)findViewById(R.id.textPartB);
        textObjectScore = (TextView)findViewById(R.id.textScore);
        textObjectLevel = (TextView)findViewById(R.id.textLevel);

        buttonObjectChoice1 = (Button)findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button)findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button)findViewById(R.id.buttonChoice3);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //um novo int é declarado para ser usado em todos os cases
        int answerGiven = 0;
        switch (view.getId()){

            case R.id.buttonChoice1:
                //inicializa a nova variavel int com o valor contido em //buttonObjectChoice1
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());


                break;

            case R.id.buttonChoice2:
                //inicializa a nova variavel int com o valor contido em //buttonObjectChoice2
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());


                break;

            case R.id.buttonChoice3:
                //inicializa a nova variavel int com o valor contido em //buttonObjectChoice3
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());


                break;
        }
    }

    void setQuestion(){

        //generate the parts of the question
        int numberRange = currentLevel * 3;
        Random randInt = new Random();

        int partA = randInt.nextInt(numberRange);
        partA++; //don't want a zero value

        int partB = randInt.nextInt(numberRange);
        partB++; //don't want a zero value

        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 2;
        int wrongAnswer2 = correctAnswer + 2;

        textObjectPartA.setText(""+partA);
        textObjectPartB.setText(""+partB);

        //set the multi choice buttons
        //a number between 0 and 2
        int buttonLayout = randInt.nextInt(3);

        switch (buttonLayout){
            case 0:
                buttonObjectChoice3.setText(""+wrongAnswer2);
                buttonObjectChoice2.setText(""+wrongAnswer1);
                buttonObjectChoice1.setText(""+correctAnswer);
            break;

            case 1:
                buttonObjectChoice1.setText(""+wrongAnswer1);
                buttonObjectChoice3.setText(""+correctAnswer);
                buttonObjectChoice2.setText(""+wrongAnswer2);
            break;

            case 2:
                buttonObjectChoice2.setText(""+correctAnswer);
                buttonObjectChoice1.setText(""+wrongAnswer1);
                buttonObjectChoice3.setText(""+wrongAnswer2);
            break;

        }
    }

    void updateScoreAndLevel(int answerGiven){
        if(isCorrect(answerGiven)){
            for(int i = 1; i <= currentLevel; i++){
                currentScore = currentScore + i;
            }

            currentLevel++;
        } else {
            currentScore = 0;
            currentLevel = 1;
        }

        //Actually update the two TextViews
        textObjectScore.setText("Score: " + currentScore);
        textObjectLevel.setText("Level: " + currentLevel);
    }

    boolean isCorrect(int answerGiven) {
        boolean correctTrueOrFalse;
        if (answerGiven == correctAnswer) {//SIM!
            Toast.makeText(getApplicationContext(), "Acerto mizeravi!", Toast.LENGTH_SHORT).show();
            correctTrueOrFalse = true;
        } else {//Ops..
            Toast.makeText(getApplicationContext(), "Sorry, ta errado", Toast.LENGTH_SHORT).show();
            correctTrueOrFalse = false;
        }
        return correctTrueOrFalse;
    }
}
