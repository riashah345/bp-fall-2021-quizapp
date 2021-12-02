package com.example.bp_fall_2021_quizapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    // UI component variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // initialize UI components
        TextView resultLabeled = (TextView) findViewById(R.id.resultLabeled);
        TextView totalScore = (TextView) findViewById(R.id.totalScore);






        // set username and score

        int score = getIntent().getIntExtra("AMOUNT ANSWERED RIGHT", 0);
        resultLabeled.setText(score + "");
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