package com.example.bp_fall_2021_quizapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    // UI component variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // initialize UI components
        first = (TextView) findViewById(R.id.res1);
        second = (TextView) findViewById(R.id.res2);
        third = (TextView) findViewById(R.id.res3);
        restartButton = (Button) findViewById((R.id.restartButton));

        StringBuffer sb1 = new StringBuffer();
        sb1.append("Correct answers: " + QuizQuestionActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + QuizQuestionActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + QuizQuestionActivity.correct + "\n");
        first.setText(sb1);
        second.setText(sb2);
        third.setText(sb3);

        QuestionsActivity.correct=0;
        QuestionsActivity.wrong=0;


        // set username and score
    }

    /**
     * Restarts the quiz so you can play another round
     * @param view
     */
    public void restart(View view) {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }
}