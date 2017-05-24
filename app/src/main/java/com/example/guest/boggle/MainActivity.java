package com.example.guest.boggle;

import java.util.Random;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.mainPlayButton) Button mMainPlayButton;
    @Bind(R.id.player1NameInput) EditText mPlayer1NameInput;
    @Bind(R.id.player2NameInput) EditText mPlayer2NameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainPlayButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == mMainPlayButton) {
            String player1Name = mPlayer1NameInput.getText().toString();
            String player2Name = mPlayer2NameInput.getText().toString();
            Intent intent = new Intent(MainActivity.this, BoggleActivity.class);
            intent.putExtra("player1Name", player1Name);
            intent.putExtra("player2Name", player2Name);
            startActivity(intent);
        }
    }
}
