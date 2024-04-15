package com.example.quizapp_achtouk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Score extends AppCompatActivity {
    Button bLogout, bTry;
    ProgressBar progressBar;
    TextView tvScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);

        // Initialize views
        tvScore = findViewById(R.id.tvScore);
        progressBar = findViewById(R.id.progressBar);
        bLogout = findViewById(R.id.bLogout);
        bTry = findViewById(R.id.bTry);

        // Get score from intent
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        // Update progress bar and score text
        updateProgress();

        // Button listeners
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Merci de votre Participation !", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        bTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this, Quiz1.class));
            }
        });
    }

    // Method to calculate and update progress
    private void updateProgress() {
        // Calculate progress based on the number of correct answers
        int totalQuestions = 5; // Assuming there are 5 questions
        int progress = (score * 100) / totalQuestions; // Calculate progress as percentage

        // Set progress and update text
        progressBar.setProgress(progress);
        tvScore.setText(progress + "%");

        // Optional: Update progress bar color based on progress
        // You can adjust the colors based on your design requirements
        if (progress == 100) {
            progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.custom_prog_bar));
        } else {
            progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.custom_prog_bar));
        }
    }
}
