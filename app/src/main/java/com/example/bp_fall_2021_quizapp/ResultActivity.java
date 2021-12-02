package com.example.bp_fall_2021_quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    // UI component variables

    private TextView resultLabeled, totalScoreLabeled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // initialize UI components
        resultLabeled = (TextView) findViewById(R.id.resultLabeled);
        totalScoreLabeled = (TextView) findViewById(R.id.totalScoreLabeled);

        // set username and score
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        int score = getIntent().getIntExtra("AMOUNT ANSWERED RIGHT", 0);
        resultLabeled.setText(score + " / 5");

        SharedPreferences settingOfApp = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = settingOfApp.getInt("totalScore", 0);

        totalScore += score;

        resultLabeled.setText(score + " / 5");
        totalScoreLabeled.setText("Total Score : " + totalScore);

        //updates total score
        SharedPreferences.Editor edit = settingOfApp.edit();
        edit.putInt("totalScore", totalScore);
        edit.commit();
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