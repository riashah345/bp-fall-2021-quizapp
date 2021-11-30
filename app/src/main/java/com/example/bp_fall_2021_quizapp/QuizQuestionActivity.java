package com.example.bp_fall_2021_quizapp;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class QuizQuestionActivity extends AppCompatActivity {

    // UI components here
    private TextView tvQuestion, tvProgress;
    private ProgressBar progress;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;

    // other variables here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        // create arraylist of questions
        questions = new ArrayList<Question>(){
            {
                add(new Question("Quanto que vale o número de Euler?", "C", "3.1415", "1.7189","2.7182", "5.985"));
                add(new Question("Quem foi que disse a seguinte frase: \"Ame o seu próximo como a si mesmo\"?", "A", "Jesus", "Hitler","Mussolini", "Stalin"));
                add(new Question("Quem é Friedrich Nietzsche?", "D", "Pedreiro", "Programador","Músico", "Filósofo"));
                add(new Question("A música \"Billie Jean\" é cantada por quem?", "B", "Whindersson Nunes", "Michael Jackson", "Kanye West", "Billie Eilish"));
                add(new Question("O que é um Ukulele?", "A", "Instrumento Musical", "Comida", "Empresa", "Time de Futebol"));
                add(new Question("Em tecnologia, o que é I.A?", "D", "Software", "Sistema Operacional", "Compilador", "Interligência Artificial"));
                add(new Question("Quanto vale 8 bits?", "C", "1 Bit", "16 Bytes", "1 Byte", "1 Mega Byte"));
                add(new Question("O que é Bitcoin?", "B", "Moeda governamental", "Crypto Moeda", "Uma rede decentralizada", "Software de Datamining"));
                add(new Question("Quem foi que criou o Bitcoin?", "B", "Margaret Hamilton", "Satoshi Nakamoto", "Alan Turing", "Gustavo Guanabara"));
                add(new Question("Quem foi o primeiro programador?", "D", "Steve Jobs", "Linus Torvalds", "Alan Turing", "Ada Lovelace"));
            }
        };
        // get username intent from main activity screen

        // initialize views using findViewByID

        // use helper method to add question content to arraylist

        // get total number of questions

        // set progress bar

        // use helper method to proceed to next question
    }

    /**
     * Method that adds questions to our questions arraylist, using the Question Model constructor
     */
    private void addQuestions(){
        // question 1

        // question 2

        // question 3

        // question 4

        // question 5

    }

    /**
     * Check the answer when user clicks submit and move on to next question
     */
    public void submitQuestion(View view){
        // if no options have been selected, prompt user to select an answer

        // use helper methods to check the answer and show the next question

    }

    /**
     * Display next question. If finished, move onto results screen
     */
    private void showNextQuestion(){

        // clear previous button selections

        // if you haven't gone through all the questions yet
            // set the question & text to the next question
            // increase question number
            // set progress bar

        // if finished with quiz, start Results activity

    }

    /**
     * Checks the answer and increases score if correct
     */
    private void checkAnswer(){
        // see which answer they picked

        // increase score if correct

    }
}