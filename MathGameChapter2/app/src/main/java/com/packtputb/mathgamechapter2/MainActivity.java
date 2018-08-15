package com.packtputb.mathgamechapter2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonPlay = (Button)findViewById(R.id.buttonPlay);

        buttonPlay.setOnClickListener(this);

    }

    //Aqui é inicializada uma intent que basicamente é uma tela de aplicativo
    // essa intent recebe a tela do jogo e com o metodo startActivity a tela
    //do jogo é invocada.
    @Override
    public void onClick(View view) {
        Intent i;
        i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
}
