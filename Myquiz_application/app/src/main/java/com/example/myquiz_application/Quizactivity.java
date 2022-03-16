package com.example.myquiz_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Quizactivity extends AppCompatActivity {

    private TextView questionNbr;
    private TextView question;

    private AppCompatButton option1, option2, option3, option4 ;
    private AppCompatButton nextBtn ;

    private Timer quizTimer;

    private int totalMin = 2;
    private int seconds = 0 ;

    private List<QuestionsList> questionsLists ;

    private int currentQuestionPosition = 0 ;

    private String selectedOption = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizactivity);

        final ImageView backBtn = findViewById(R.id.back_btn);
        final TextView timer = findViewById(R.id.timer);

        questionNbr = findViewById(R.id.question_number);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);
        option3 = findViewById(R.id.option_3);
        option4 = findViewById(R.id.option_4);

        nextBtn = findViewById(R.id.nextBtn);

        questionsLists = QuestionBank.getQuestions();


        startTimer(timer);

        questionNbr.setText("Question "+ (currentQuestionPosition+1));
        question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
        option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
        option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
        option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
        option4.setText(questionsLists.get(currentQuestionPosition).getOption4());



        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.isEmpty()){
                    selectedOption = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOption);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.isEmpty()){
                    selectedOption = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOption);
                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.isEmpty()){
                    selectedOption = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOption);
                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.isEmpty()){
                    selectedOption = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOption);
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.isEmpty()){
                    Toast.makeText(Quizactivity.this,"Vous devez choisir une réponse",Toast.LENGTH_SHORT).show();
                }
                else {
                    changeNextQst();
                }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(Quizactivity.this,MainActivity.class));
                finish();
            }
        });


    }

    private void changeNextQst(){
        currentQuestionPosition++;
        if (currentQuestionPosition+1 == questionsLists.size()){
            nextBtn.setText("Valider le Quiz");
        }
        else if (currentQuestionPosition<questionsLists.size()){
            selectedOption = "";
            option1.setBackgroundResource(R.drawable.round_back_white_answers);
            option2.setBackgroundResource(R.drawable.round_back_white_answers);
            option3.setBackgroundResource(R.drawable.round_back_white_answers);
            option4.setBackgroundResource(R.drawable.round_back_white_answers);

            questionNbr.setText("Question"+ (currentQuestionPosition+1));
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(currentQuestionPosition).getOption4());
        }
        else {
            Intent intent = new Intent(Quizactivity.this,QuizResults.class);
            intent.putExtra("Correct", getCorrectAnswers());
            intent.putExtra("Incorrect", getIncorrectAnswers());
            startActivity(intent);
            finish();
        }
    }

    private void startTimer(TextView timerTextView){
        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0 & totalMin == 0 ){
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(Quizactivity.this, "Temps écoulé", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Quizactivity.this,QuizResults.class);

                    intent.putExtra("Correct",getCorrectAnswers());
                    intent.putExtra("Incorrect",getIncorrectAnswers());
                    startActivity(intent);
                    finish();
                }
                else if (seconds == 0){
                    totalMin-- ;
                    seconds = 59;
                }
                else{
                    seconds--;
                }

                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf(totalMin);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length()==1){
                            finalMinutes = "0" + finalMinutes;
                        }
                        if (finalSeconds.length() == 1){
                            finalSeconds = "0" + finalSeconds ;
                        }
                        timerTextView.setText(finalMinutes + ":" + finalSeconds);
                    }
                });

            }
        }, 1000, 1000);
    }

    private int getCorrectAnswers(){

        int correctAnswers = 0;

        for (int i =0; i < questionsLists.size(); i++){
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getIncorrectAnswers(){

        int incorrectAnswers = 0;

        for (int i =0; i < questionsLists.size(); i++){
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)){
                incorrectAnswers++;
            }
        }
        return incorrectAnswers;
    }

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(Quizactivity.this,MainActivity.class));
        finish();
    }

    private void revealAnswer(){
        final String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();

        if (option1.getText().toString().equals(getAnswer)){
             option1.setBackgroundResource(R.drawable.round_back_green);
        }
        else if (option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green);
        }
        else if (option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green);
        }
        else if (option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green);
        }


    }
}
