package com.example.android.quizapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int quiz_score = 0;
    int max_score = 12;
    float q3_sub_score = 0;
    float q5_sub_score = 0;
    float q11_sub_score = 0;

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

    private static final String TAG = "QuizAnswers";

    //Validate guesses
    public void checkAnswers (View view){
        //re-initialize quiz score and sub-scores
        resetQuizScores();

        //check answer to Question 1
        EditText guess_Q1 = (EditText) findViewById(R.id.q1_textbox);
        String q1_string = guess_Q1.getText().toString().toLowerCase();
        if ( q1_string.equals(getString(R.string.question01_answer))) {
            quiz_score += 1;
        };

        //check answer to Question 2
        RadioButton q2_correct_answer = (RadioButton) (findViewById(R.id.q2_radio_answer));

        if (q2_correct_answer.isChecked() == true){
            quiz_score += 1;
        }

        //check answer to Question 3
        CheckBox q3_cb1 = (CheckBox) (findViewById(R.id.q3_check_guess1));
        CheckBox q3_cb2 = (CheckBox) (findViewById(R.id.q3_check_guess2));
        CheckBox q3_cb3 = (CheckBox) (findViewById(R.id.q3_check_guess3));
        CheckBox q3_cb4 = (CheckBox) (findViewById(R.id.q3_check_guess4));

        if (q3_cb1.isChecked() == true){
            q3_sub_score += .25;
        }

        if (q3_cb2.isChecked() == true){
            q3_sub_score += .25;
        }

        if (q3_cb3.isChecked() == true){
            q3_sub_score += .25;
        }

        if (q3_cb4.isChecked() == true){
            q3_sub_score += .25;
        }

        if (q3_sub_score == 1.0){
            quiz_score += 1;
        }

        //check answer to Question 4
        RadioButton q4_correct_answer = (RadioButton) (findViewById(R.id.q4_radio3));

        if( q4_correct_answer.isChecked() == true) {
            quiz_score += 1;
        }

        //check answers to Question 5
        //check gate answer
        EditText q5_Gate = (EditText) findViewById(R.id.q5_textbox1);
        String q5_gate_guess = q5_Gate.getText().toString();
        if (q5_gate_guess.equals(getString(R.string.question05_answer_gate))) {
            q5_sub_score += .5;

            //set status color
        }

        //check flight answer
        EditText q5_Flight = (EditText) findViewById(R.id.q5_textbox2);
        String q5_flight_guess = q5_Flight.getText().toString();
        if (q5_flight_guess.equals(getString(R.string.question05_answer_flight))){
            q5_sub_score += .5;

            //set status color
        }

        if (q5_sub_score == 1.0){
            quiz_score += 1;
        }

        //check answer to Question 6
        RadioButton q6_correct_answer = (RadioButton) (findViewById(R.id.q6_radio1));

        if (q6_correct_answer.isChecked() == true){
            quiz_score += 1;
        }


        //check answer to Question 7
        EditText guess_Q7 = (EditText) findViewById(R.id.q7_textbox);
        String q7_string = guess_Q7.getText().toString();
        if (q7_string.equals(getString(R.string.question07_answer))){
            quiz_score += 1;

            //set status color
        }

        //check answer to Question 8
        RadioButton q8_correct_answer = (RadioButton) (findViewById(R.id.q8_radio1));

        if (q8_correct_answer.isChecked() == true){
            quiz_score += 1;
        }

        //check answer to Question 9
        RadioButton q9_correct_answer = (RadioButton) (findViewById(R.id.q9_radio4));

        if (q9_correct_answer.isChecked() == true) {
            quiz_score += 1;
        }

        //check answer to Question 10
        RadioButton q10_correct_answer = (RadioButton) (findViewById(R.id.q10_radio1));

        if (q10_correct_answer.isChecked() == true) {
            quiz_score += 1;
        }

        //check answer to Question 11
        CheckBox q11_cb1 = (CheckBox)(findViewById(R.id.q11_check_guess1));
        CheckBox q11_cb2 = (CheckBox)(findViewById(R.id.q11_check_guess2));
        CheckBox q11_cb3 = (CheckBox)(findViewById(R.id.q11_check_guess3));
        CheckBox q11_cb4 = (CheckBox)(findViewById(R.id.q11_check_guess4));

        if (q11_cb1.isChecked() == true){
            q11_sub_score += -1;
        }

        if (q11_cb2.isChecked() == true){
            q11_sub_score += .333;
        }

        if (q11_cb3.isChecked() == true){
            q11_sub_score += .333;
        }

        if (q11_cb4.isChecked() == true){
            q11_sub_score += .334;
        }

        if (q11_sub_score == 1.0){
            quiz_score += 1;
        }

        //check answer to Question 12
        RadioButton q12_correct_answer = (RadioButton) (findViewById(R.id.q12_radio4));

        if(q12_correct_answer.isChecked() == true){
            quiz_score += 1;
        }

        displayScore(quiz_score);

        return;
    }


    //Display quiz result message
    public void displayScore (int quizScoreTotal){
        String quiz_result_msg = "You got " + quizScoreTotal + " out of " + max_score + ".";
        TextView quizResult = (TextView) (findViewById(R.id.quiz_result_textview));

        //if result message is already displayed, hide previous score.
        hideScore();

        quizResult.setText(quiz_result_msg);
        quizResult.setVisibility(View.VISIBLE);
        quizResult.requestFocus();

    }

    public void hideScore (){
        TextView quizResult = (TextView) (findViewById(R.id.quiz_result_textview));

        if (quizResult.getVisibility() == View.VISIBLE){
            quizResult.setVisibility(View.GONE);
        }

    }

    //reset quiz answers
    public void resetQuiz(View view){
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

        //Hide score
        hideScore();

        resetQuizScores();


    }

    //reset quiz scores
    public void resetQuizScores (){
        //clear quiz score
        quiz_score = 0;

        //clear sub scores
        q3_sub_score = 0;
        q5_sub_score = 0;
        q11_sub_score = 0;
    }


}
