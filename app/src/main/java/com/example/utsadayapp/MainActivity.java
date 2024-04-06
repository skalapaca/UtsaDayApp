package com.example.utsadayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] buttonIds = {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9};
    private Random random;
    private int hiddenBirdId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView birdsCaught = findViewById(R.id.birds_caught);
        birdsCaught.setText("Birds caught: 0");
        final int[] numBirdsCaught = {0};

        random = new Random();

        resetHiddenBird();

        for (int id : buttonIds) {
            Button button = findViewById(id);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickedButton = view.getId();

                    if (clickedButton == hiddenBirdId){
                        Toast.makeText(view.getContext(), "Meep meep!", Toast.LENGTH_SHORT).show();
                        ++numBirdsCaught[0];
                        birdsCaught.setText("Birds caught: " + numBirdsCaught[0]);
                        resetHiddenBird();
                    }
                }
            });
        }
    }
    public void resetHiddenBird(){
        hiddenBirdId = buttonIds[random.nextInt(buttonIds.length)];
    }
}


