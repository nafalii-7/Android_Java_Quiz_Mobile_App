package com.example.myquiz_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final AppCompatButton startNewBtn = findViewById(R.id.start_new_quiz);
        final TextView correctAnswers = findViewById(R.id.correct);
        final TextView incorrectAnswers = findViewById(R.id.incorrect);


        final int getCorrectAnswers = getIntent().getIntExtra("correct",0);
        final int getIncorrectAnswers = getIntent().getIntExtra("incorrect",0);

        correctAnswers.setText("Correct : " + getCorrectAnswers);
        incorrectAnswers.setText("Incorrect : " + getIncorrectAnswers);

        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResults.this, Quizactivity.class));
                finish();
            }
        });

    }
}