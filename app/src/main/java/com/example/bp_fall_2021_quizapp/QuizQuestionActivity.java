package com.example.bp_fall_2021_quizapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestionActivity extends AppCompatActivity {

    // UI components here
    private TextView questionTextView;
    private RadioGroup radioGroup;
    private ProgressBar progress;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button nextButton;

    // other variables here
    private List<QuestionModel> questions;
    int questionTotal;
    int questionCounter;
    ColorStateList color;
    boolean answeredQuestion;
    private QuestionModel currQuestion;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        // create arraylist of questions
        questions = new ArrayList<>();
        // get username intent from main activity screen
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        // initialize views using findViewByID
        questionTextView.findViewById(R.id.questionTextView);
        radioGroup.findViewById(R.id.radioGroup);
        progress.findViewById(R.id.progress);
        rb1.findViewById(R.id.rb1);
        rb2.findViewById(R.id.rb2);
        rb3.findViewById(R.id.rb3);
        rb4.findViewById(R.id.rb4);
        nextButton.findViewById(R.id.nextButton);
        color = rb1.getTextColors();

        // use helper method to add question content to arraylist
        addQuestions();

        // get total number of questions
        questionTotal = questions.size();

        // set progress bar
        progress.setProgress(Integer.parseInt("Question: "+questionCounter+"/"+questionTotal));

        // use helper method to proceed to next question
        showNextQuestion();
    }

    /**
     * Method that adds questions to our questions arraylist, using the Question Model constructor
     */
    private void addQuestions(){
        // question 1
        questions.add(new QuestionModel("What is the most stolen food item in the world?", "Bread", "Cheese", "Milk","Fruits", 2));
        // question 2
        questions.add(new QuestionModel("How many cups of coffee does Starbucks sell a day?", "87,000", "56,000", "124,000","202,000", 1));
        // question 3
        questions.add(new QuestionModel("What is the most expensive spice by weight in the world?", "Saffron", "Cardamom", "Vanilla bean","Fennel", 1));
        // question 4
        questions.add(new QuestionModel("What food never goes bad?", "Chocolate", "Potatoes", "Avocados", "Honey", 4));
        // question 5
        questions.add(new QuestionModel("What is not considered a fruit?", "Olives", "Cucumber", "Kale", "Avocado", 3));

    }

    /**
     * Check the answer when user clicks submit and move on to next question
     */
    public void submitQuestion(View view){
        // if no options have been selected, prompt user to select an answer
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answeredQuestion == false) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    }
                    else {
                        Toast.makeText(QuizQuestionActivity.this, "Please choose an answer", Toast.LENGTH_SHORT).show();
                    }
                }

        // use helper methods to check the answer and show the next question
                else {
                    showNextQuestion();
                }
            }
        });
    }

    /**
     * Display next question. If finished, move onto results screen
     */
    private void showNextQuestion(){
        // clear previous button selections
        radioGroup.clearCheck();
        rb1.setTextColor(color);
        rb2.setTextColor(color);
        rb3.setTextColor(color);
        rb4.setTextColor(color);

        // if you haven't gone through all the questions yet
        // set the question & text to the next question
        if(questionCounter < questionTotal) {
            currQuestion = questions.get(questionCounter);
            questionTextView.setText(currQuestion.getQuestion());
            rb1.setText(currQuestion.getOpt1());
            rb2.setText(currQuestion.getOpt2());
            rb3.setText(currQuestion.getOpt3());
            rb4.setText(currQuestion.getOpt4());

        // increase question number
            questionCounter++;
            nextButton.setText("Submit");
        // set progress bar
            progress.setProgress(Integer.parseInt("Question: "+questionCounter+"/"+questionTotal));
            answeredQuestion = false;

        // if finished with quiz, start Results activity
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * Checks the answer and increases score if correct
     */
    private void checkAnswer(){
        // see which answer they picked
        answeredQuestion = true;
        RadioButton buttonSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNumber = radioGroup.indexOfChild(buttonSelected) + 1;

        // increase score if correct
        if(answerNumber == currQuestion.getCorrectAnsNum()) {
            total++;
        }

        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currQuestion.getCorrectAnsNum()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
        }
        if (questionCounter < questionTotal) {
            nextButton.setText("Next");
        }
        else {
            nextButton.setText("Finish");
        }
    }
}