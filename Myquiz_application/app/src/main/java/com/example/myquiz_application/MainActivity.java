package com.example.myquiz_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button Start_btn =findViewById(R.id.start);

        Start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Start_btn.setBackgroundResource(R.drawable.round_back_file_with_color);

                Intent intent = new Intent( MainActivity.this,Quizactivity.class);
                startActivity(intent);

            }
        });
    }


}

