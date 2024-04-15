package com.example.quizapp_achtouk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Quiz1 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score = 0;
    boolean correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        rg = findViewById(R.id.rg);
        bNext = findViewById(R.id.bNext);



        bNext.setOnClickListener(v -> {
            if (rg.getCheckedRadioButtonId() == -1) {
                Toast.makeText(getApplicationContext(), "Merci de choisir une réponse S.V.P !", Toast.LENGTH_SHORT).show();
            } else {
                rb = findViewById(rg.getCheckedRadioButtonId());
                boolean selectedAnswer = rb.getText().toString().equals("Oui"); // Assuming "Oui" is the user's selected answer

                if (selectedAnswer == correctAnswer) {
                    score += 1;
                }

                Intent intent = new Intent(Quiz1.this, Quiz2.class);
                intent.putExtra("score", score);
                startActivity(intent);

                finish();
            }
        });
    }
}
