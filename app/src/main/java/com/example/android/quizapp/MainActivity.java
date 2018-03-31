package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int quiz_score = 0;
    int max_score = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        //save state of text boxes
        final EditText guess_Q1 = (EditText) findViewById(R.id.q1_textbox);
        CharSequence guessText_Q1 = guess_Q1.getText();
        savedInstanceState.putCharSequence("savedGuessQ1",guessText_Q1);

        final EditText gate_guess_Q5 = (EditText) findViewById(R.id.q5_textbox1);
        CharSequence gate_text_Q5 = gate_guess_Q5.getText();
        savedInstanceState.putCharSequence("savedGateGuessQ5",gate_text_Q5);

        final EditText flt_guess_Q5 = (EditText) findViewById(R.id.q5_textbox2);
        CharSequence flt_text_Q5 = flt_guess_Q5.getText();
        savedInstanceState.putCharSequence("savedFltGuessQ5",flt_text_Q5);

        final EditText guess_Q7 = (EditText) findViewById(R.id.q7_textbox);
        CharSequence guessText_Q7 = guess_Q7.getText();
        savedInstanceState.putCharSequence("savedGuessQ7",guessText_Q7);


        //save quiz score
        savedInstanceState.putInt("savedQuizScore",quiz_score);

    }

    @Override
    protected void onRestoreInstanceState (Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        //restore text box values
        final EditText guess_Q1 = (EditText) findViewById(R.id.q1_textbox);
        CharSequence guessText_Q1 = savedInstanceState.getCharSequence("savedGuessQ1");
        guess_Q1.setText(guessText_Q1);

        final EditText gate_guess_Q5 = (EditText) findViewById(R.id.q5_textbox1);
        CharSequence gate_text_Q5 = savedInstanceState.getCharSequence("savedGateGuessQ5");
        gate_guess_Q5.setText(gate_text_Q5);

        final EditText flt_guess_Q5 = (EditText) findViewById(R.id.q5_textbox2);
        CharSequence flt_text_Q5 = savedInstanceState.getCharSequence("savedFltGuessQ5");
        flt_guess_Q5.setText(flt_text_Q5);

        final EditText guess_Q7 = (EditText) findViewById(R.id.q7_textbox);
        CharSequence guessText_Q7 = savedInstanceState.getCharSequence("savedGuess07");
        guess_Q7.setText(guessText_Q7);


        //restore quiz score
        quiz_score = savedInstanceState.getInt("savedQuizScore");
    }


    //Highlight selected answer(s)


    //Validate guesses


    // Calculate score


    //Display quiz result message


    //reset quiz
    public void resetQuiz(View view){

    }

}
