package com.example.pedro_master.jogodamemoria;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends Activity implements View.OnClickListener{

    //inicializa as variaveis de som
    private SoundPool soundPool;
    int sample1 = -1;
    int sample2 = -1;
    int sample3 = -1;
    int sample4 = -1;

    //variaveis da interface grafica
    TextView textScore;
    TextView textDifficulty;
    TextView textWatchGo;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button buttonReplay;

    //algumas variaveis para nossa thread
    int difficultyLevel = 3;
    //Um array para guardar a sequencia aleatoria
    int[] sequenceToCopy = new int[100];

    private Handler myHandler;
    //nós estamos jogando uma sequencia no momento?
    boolean playSequence = false;
    //E qual elemento da sequência nós estamos
    int elementToPlay = 0;

    //para checar a resposta do jogador
    int playerResponses;
    int playerScore;
    boolean isResponding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try{
            //Cria-se um objeto de duas classes requeridas
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            //criação dos 4 sons na memoria prontos para uso
            descriptor = assetManager.openFd("sample1.ogg");
            sample1 = soundPool.load(descriptor,0);

            descriptor = assetManager.openFd("sample2.ogg");
            sample2 = soundPool.load(descriptor,0);

            descriptor = assetManager.openFd("sample3.ogg");
            sample3 = soundPool.load(descriptor,0);

            descriptor = assetManager.openFd("sample4.ogg");
            sample4 = soundPool.load(descriptor,0);

        }catch (Exception e){
            //caso dê algum erro...
        }

        //linkando as variaveis com os itens da tela
        textScore = (TextView)findViewById(R.id.textScore);
        textScore.setText("Score: " + playerScore);

        textDifficulty = (TextView)findViewById(R.id.textDifficulty);
        textDifficulty.setText("Level: " + difficultyLevel);
        textWatchGo = (TextView)findViewById(R.id.textWatchGo);

        //agora os botoes
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        buttonReplay = (Button)findViewById(R.id.buttonReplay);

        //deixando os botoes prontos para ouvir cliques
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        buttonReplay.setOnClickListener(this);

        //Esse é o codigo que define a thread
        myHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (playSequence) {
                    //All the thread action will go here
                    //make sure all the buttons are made visible
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);

                    switch (sequenceToCopy[elementToPlay]){
                        case 1:
                            //hide a button
                            button1.setVisibility(View.INVISIBLE);
                            //play a sound
                            soundPool.play(sample1, 1, 1, 0, 0, 1);
                            break;

                        case 2:
                            //hide a button
                            button2.setVisibility(View.INVISIBLE);
                            //play a sound
                            soundPool.play(sample2, 1, 1, 0, 0, 1);
                            break;

                        case 3:
                            //hide a button
                            button3.setVisibility(View.INVISIBLE);
                            //play a sound
                            soundPool.play(sample3, 1, 1, 0, 0, 1);
                            break;

                        case 4:
                            //hide a button
                            button4.setVisibility(View.INVISIBLE);
                            //play a sound
                            soundPool.play(sample4, 1, 1, 0, 0, 1);
                            break;
                    }

                    elementToPlay++;
                    if(elementToPlay == difficultyLevel){
                        sequenceFinished();
                    }
                }

                myHandler.sendEmptyMessageDelayed(0, 900);
            }


        };//fim da thread

        myHandler.sendEmptyMessage(0);
        playASequence();
    }

    @Override
    public void onClick(View view) {


    }

    public void creatSequence(){
        //escolhe um botao aleatorio
        Random randInt = new Random();
        int ourRandom;
        for(int i = 0; i < difficultyLevel; i++){
        //recebe um numero aleatorio entre 1 e 4
            ourRandom = randInt.nextInt(4);
            ourRandom++;//garante que nao venha um zero
            //salva o numero no array
            sequenceToCopy[i] = ourRandom;
        }

    }

    public void playASequence(){
        creatSequence();
        isResponding = false;
        elementToPlay = 0;
        playerResponses = 0;
        textWatchGo.setText("WHTCH!");
        playSequence = true;
    }

    public void sequenceFinished(){
        playSequence = false;
        //tenha certeza que todos os botoes estao visiveis
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        textWatchGo.setText("GO!");
        isResponding = true;
    }

}
