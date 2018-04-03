package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

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
    public int checkAnswers (View view){
        //check answer to Question 1
        EditText guess_Q1 = (EditText) findViewById(R.id.q1_textbox);
        String guess_Q1_trimeed = guess_Q1.getText().toString().trim();

        if (guess_Q1_trimeed == getString(R.string.question01_answer)) {
            quiz_score += 1;
        };

        //check answer to Question 2


        //check answer to Question 3


        //check answer to Question 4


        //check answers to Question 5
        //check gate answer
        int q5_sub_score = 0;
        EditText q5_Gate = (EditText) findViewById(R.id.q5_textbox1);
        if (q5_Gate.getText().toString() == getString(R.string.question05_answer_gate)){
            q5_sub_score += .5;

            //set status color
        }

        //check flight answer
        EditText q5_Flight = (EditText) findViewById(R.id.q5_textbox2);
        if (q5_Flight.getText().toString() == getString(R.string.question05_answer_flight)){
            q5_sub_score += .5;

            //set status color
        }

        if (q5_sub_score == 1){
            quiz_score += 1;
        }

        //check answer to Question 6


        //check answer to Question 7
        EditText guess_Q7 = (EditText) findViewById(R.id.q7_textbox);
        if (guess_Q7.getText().toString() == getString(R.string.question07_answer)){
            quiz_score += 1;

            //set status color
        }


        //check answer to Question 8


        //check answer to Question 9


        //check answer to Question 10


        //check answer to Question 11


        //check answer to Question 12

        return quiz_score;
    }


    // Calculate score


    //Display quiz result message


    //reset quiz
    public void resetQuiz(View view){
        //reset quiz score
        quiz_score = 0;

        //Clear Question 1
        EditText guess_Q1 = (EditText) findViewById(R.id.q1_textbox);
        guess_Q1.setText("");

        //Clear Question 2
        RadioGroup q2_Answers = (RadioGroup) (findViewById(R.id.q2_radioGroup));
        q2_Answers.clearCheck();

        //Clear Question 3 checkboxes
        CheckBox q3_chkbox1 = (CheckBox) (findViewById(R.id.q3_check_guess1));
        CheckBox q3_chkbox2 = (CheckBox) (findViewById(R.id.q3_check_guess2));
        CheckBox q3_chkbox3 = (CheckBox) (findViewById(R.id.q3_check_guess3));
        CheckBox q3_chkbox4 = (CheckBox) (findViewById(R.id.q3_check_guess4));

        if (q3_chkbox1.isChecked()){
            q3_chkbox1.toggle();
        }

        if (q3_chkbox2.isChecked()){
            q3_chkbox2.toggle();
        }

        if (q3_chkbox3.isChecked()){
            q3_chkbox3.toggle();
        }

        if (q3_chkbox4.isChecked()){
            q3_chkbox4.toggle();
        }

        //Clear Question 4
        RadioGroup q4_Answers = (RadioGroup) (findViewById(R.id.q4_radioGroup));
        q4_Answers.clearCheck();

        //Clear Question 5
        EditText gateGuess_Q5 = (EditText) findViewById(R.id.q5_textbox1);
        gateGuess_Q5.setText("");

        EditText flightGuess_Q5 = (EditText) findViewById(R.id.q5_textbox2);
        flightGuess_Q5.setText("");

        //Clear Question 6
        RadioGroup q6_Answers = (RadioGroup) (findViewById(R.id.q6_radioGroup));
        q6_Answers.clearCheck();

        //Clear Question 7
        EditText guess_Q7 = (EditText) findViewById(R.id.q7_textbox);
        guess_Q7.setText("");

        //Clear Question 8
        RadioGroup q8_Answers = (RadioGroup) (findViewById(R.id.q8_radioGroup));
        q8_Answers.clearCheck();

        //Clear Question 9
        RadioGroup q9_Answers = (RadioGroup) (findViewById(R.id.q9_radioGroup));
        q9_Answers.clearCheck();

        //Clear Question 10
        RadioGroup q10_Answers = (RadioGroup) (findViewById(R.id.q10_radioGroup));
        q10_Answers.clearCheck();

        //Clear Question 11 checkboxes
        CheckBox q11_chkbox1 = (CheckBox) (findViewById(R.id.q11_check_guess1));
        CheckBox q11_chkbox2 = (CheckBox) (findViewById(R.id.q11_check_guess2));
        CheckBox q11_chkbox3 = (CheckBox) (findViewById(R.id.q11_check_guess3));
        CheckBox q11_chkbox4 = (CheckBox) (findViewById(R.id.q11_check_guess4));

        if (q11_chkbox1.isChecked()){
            q11_chkbox1.toggle();
        }

        if (q11_chkbox2.isChecked()){
            q11_chkbox2.toggle();
        }

        if (q11_chkbox3.isChecked()){
            q11_chkbox3.toggle();
        }

        if (q11_chkbox4.isChecked()){
            q11_chkbox4.toggle();
        }

        //Clear Question 12
        RadioGroup q12_Answers = (RadioGroup) (findViewById(R.id.q12_radioGroup));
        q12_Answers.clearCheck();

        guess_Q1.requestFocus();

        return;
    }

}
