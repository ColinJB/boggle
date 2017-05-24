package com.example.guest.boggle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import butterknife.Bind;
import butterknife.ButterKnife;

public class BoggleActivity extends AppCompatActivity {
    public static final String[] LETTERS = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static final String[] VOWELS = new String[] {"A", "E", "I", "O", "U", "Y"};
    @Bind(R.id.player1NameBoggle) TextView mPlayer1NameBoggle;
    @Bind(R.id.player2NameBoggle) TextView mPlayer2NameBoggle;
    @Bind(R.id.gridViewBoggle) GridView mGridViewBoggle;


    public static ArrayList<String> generateStringArray() {
        Random random = new Random();
        ArrayList<String> text = new ArrayList<String>();

        for (int i = 0; i < 6; i++) {
            text.add(LETTERS[random.nextInt(LETTERS.length)]);
        }
        for (int i = 6; i < 8; i++) {
            text.add(VOWELS[random.nextInt(VOWELS.length)]);
        }

        return text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boggle);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String player1Name = intent.getStringExtra("player1Name");
        String player2Name = intent.getStringExtra("player2Name");

        ArrayList<String> letters = generateStringArray();

        mGridViewBoggle = (GridView) findViewById(R.id.gridViewBoggle);
        mGridViewBoggle.setAdapter(new LetterAdapter(this, letters));

        mPlayer1NameBoggle.setText(player1Name);
        mPlayer2NameBoggle.setText(player2Name);

    }

}
