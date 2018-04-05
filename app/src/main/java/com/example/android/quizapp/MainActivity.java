package com.example.android.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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


    /**
     * This method is called to save any values that are not retained by the
     * app by default when the activity is destroyed and can be restored.
     *
     * @param savedInstanceState Bundle object to which app values are saved
     *                           to be restored later.
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //save state of text boxes
        final EditText guess_Q1 = findViewById(R.id.q1_textbox);
        CharSequence guessText_Q1 = guess_Q1.getText();
        savedInstanceState.putCharSequence("savedGuessQ1", guessText_Q1);

        final EditText gate_guess_Q5 = findViewById(R.id.q5_textbox1);
        CharSequence gate_text_Q5 = gate_guess_Q5.getText();
        savedInstanceState.putCharSequence("savedGateGuessQ5", gate_text_Q5);

        final EditText flt_guess_Q5 = findViewById(R.id.q5_textbox2);
        CharSequence flt_text_Q5 = flt_guess_Q5.getText();
        savedInstanceState.putCharSequence("savedFltGuessQ5", flt_text_Q5);

        final EditText guess_Q7 = findViewById(R.id.q7_textbox);
        CharSequence guessText_Q7 = guess_Q7.getText();
        savedInstanceState.putCharSequence("savedGuessQ7", guessText_Q7);


        //save quiz score
        savedInstanceState.putInt("savedQuizScore", quiz_score);

    }


    /**
     * This method is called to restore any values to the app when the
     * activity must be restarted, for example, when screen orientation
     * changes.
     *
     * @param savedInstanceState Bundle object containing saved values when
     *                           activity was destroyed.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //restore text box values
        final EditText guess_Q1 = findViewById(R.id.q1_textbox);
        CharSequence guessText_Q1 = savedInstanceState.getCharSequence("savedGuessQ1");
        guess_Q1.setText(guessText_Q1);

        final EditText gate_guess_Q5 = findViewById(R.id.q5_textbox1);
        CharSequence gate_text_Q5 = savedInstanceState.getCharSequence("savedGateGuessQ5");
        gate_guess_Q5.setText(gate_text_Q5);

        final EditText flt_guess_Q5 = findViewById(R.id.q5_textbox2);
        CharSequence flt_text_Q5 = savedInstanceState.getCharSequence("savedFltGuessQ5");
        flt_guess_Q5.setText(flt_text_Q5);

        final EditText guess_Q7 = findViewById(R.id.q7_textbox);
        CharSequence guessText_Q7 = savedInstanceState.getCharSequence("savedGuessQ7");
        guess_Q7.setText(guessText_Q7);


        //restore quiz score
        quiz_score = savedInstanceState.getInt("savedQuizScore");
    }

    /**
     * This method is called when the user clicks the Submit button
     * to check the answers to the quiz. In addition to validating the answers,
     * this method will tally the number of correct answers to display back to
     * the user, highlight the correct answer if it is not already selected,
     * and call other methods to highlight the result of each question.
     *
     * @param view default parameter, optional.
     */
    public void checkAnswers(View view) {
        //re-initialize quiz score and sub-scores
        resetQuizScores();

        //reset highlighting of correct answers
        removeHighlighting();

        //check answer to Question 1
        EditText guess_Q1 = findViewById(R.id.q1_textbox);
        String q1Guess = guess_Q1.getText().toString();
        //capitalize first letter of guess for comparison to correct answer
        if (q1Guess.trim().length() > 1) {
            q1Guess = q1Guess.substring(0, 1).toUpperCase() + q1Guess.substring(1).toLowerCase();
        }

        if (q1Guess.equals(getString(R.string.question01_answer))) {
            quiz_score += 1;
            displayCorrectResult("Q1");
        } else {
            displayIncorrectResult("Q1");
        }

        //check answer to Question 2
        RadioButton q2_correct_answer = findViewById(R.id.q2_radio_answer);

        if (q2_correct_answer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q2");
        } else {
            displayIncorrectResult("Q2");
            q2_correct_answer.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 3
        CheckBox q3_cb1 = findViewById(R.id.q3_check_guess1);
        CheckBox q3_cb2 = findViewById(R.id.q3_check_guess2);
        CheckBox q3_cb3 = findViewById(R.id.q3_check_guess3);
        CheckBox q3_cb4 = findViewById(R.id.q3_check_guess4);

        if (q3_cb1.isChecked()) {
            q3_sub_score += .25;
        }

        if (q3_cb2.isChecked()) {
            q3_sub_score += .25;
        }

        if (q3_cb3.isChecked()) {
            q3_sub_score += .25;
        }

        if (q3_cb4.isChecked()) {
            q3_sub_score += .25;
        }

        if (q3_sub_score == 1.0) {
            quiz_score += 1;
            displayCorrectResult("Q3");
        } else {
            displayIncorrectResult("Q3");

            q3_cb1.setBackgroundResource(R.color.correctColor);
            q3_cb2.setBackgroundResource(R.color.correctColor);
            q3_cb3.setBackgroundResource(R.color.correctColor);
            q3_cb4.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 4
        RadioButton q4_correct_answer = findViewById(R.id.q4_radio3);

        if (q4_correct_answer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q4");
        } else {
            displayIncorrectResult("Q4");
            q4_correct_answer.setBackgroundResource(R.color.correctColor);
        }

        //check answers to Question 5
        //check gate answer
        EditText q5_Gate = findViewById(R.id.q5_textbox1);
        String q5_gate_guess = q5_Gate.getText().toString();
        if (q5_gate_guess.equals(getString(R.string.question05_answer_gate))) {
            q5_sub_score += .5;
        }

        //check flight answer
        EditText q5_Flight = findViewById(R.id.q5_textbox2);
        String q5_flight_guess = q5_Flight.getText().toString();
        if (q5_flight_guess.equals(getString(R.string.question05_answer_flight))) {
            q5_sub_score += .5;
        }

        if (q5_sub_score == 1.0) {
            quiz_score += 1;
            displayCorrectResult("Q5");
        } else {
            displayIncorrectResult("Q5");
        }

        //check answer to Question 6
        RadioButton q6_correct_answer = findViewById(R.id.q6_radio1);

        if (q6_correct_answer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q6");
        } else {
            displayIncorrectResult("Q6");
            q6_correct_answer.setBackgroundResource(R.color.correctColor);
        }


        //check answer to Question 7
        EditText guess_Q7 = findViewById(R.id.q7_textbox);
        String q7_string = guess_Q7.getText().toString();

        if (q7_string.equals(getString(R.string.question07_answer))) {
            quiz_score += 1;
            displayCorrectResult("Q7");
        } else {
            displayIncorrectResult("Q7");
        }

        //check answer to Question 8
        RadioButton q8_correct_answer = findViewById(R.id.q8_radio1);

        if (q8_correct_answer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q8");
        } else {
            displayIncorrectResult("Q8");
            q8_correct_answer.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 9
        RadioButton q9_correct_answer = findViewById(R.id.q9_radio4);

        if (q9_correct_answer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q9");
        } else {
            displayIncorrectResult("Q9");
            q9_correct_answer.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 10
        RadioButton q10_correct_answer = findViewById(R.id.q10_radio1);

        if (q10_correct_answer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q10");
        } else {
            displayIncorrectResult("Q10");
            q10_correct_answer.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 11
        CheckBox q11_cb1 = findViewById(R.id.q11_check_guess1);
        CheckBox q11_cb2 = findViewById(R.id.q11_check_guess2);
        CheckBox q11_cb3 = findViewById(R.id.q11_check_guess3);
        CheckBox q11_cb4 = findViewById(R.id.q11_check_guess4);

        if (q11_cb1.isChecked()) {
            q11_sub_score += -1;
        }

        if (q11_cb2.isChecked()) {
            q11_sub_score += .333;
        }

        if (q11_cb3.isChecked()) {
            q11_sub_score += .333;
        }

        if (q11_cb4.isChecked()) {
            q11_sub_score += .334;
        }

        if (q11_sub_score == 1.0) {
            quiz_score += 1;
            displayCorrectResult("Q11");
        } else {
            displayIncorrectResult("Q11");
            q11_cb2.setBackgroundResource(R.color.correctColor);
            q11_cb3.setBackgroundResource(R.color.correctColor);
            q11_cb4.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 12
        RadioButton q12_correct_answer = findViewById(R.id.q12_radio4);

        if (q12_correct_answer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q12");
        } else {
            displayIncorrectResult("Q12");
            q12_correct_answer.setBackgroundResource(R.color.correctColor);
        }

        displayScore(quiz_score);
    }

    /**
     * This method will display a message highlighted in green to indicate
     * that a question has been answered correctly.
     *
     * @param questionNum String referring to the question number passed in
     *                    the form, "Qx" where x is an integer 1-12.
     */
    public void displayCorrectResult(String questionNum) {
        TextView result_Q1 = findViewById(R.id.q1_result_text);
        TextView result_Q2 = findViewById(R.id.q2_result_text);
        TextView result_Q3 = findViewById(R.id.q3_result_text);
        TextView result_Q4 = findViewById(R.id.q4_result_text);
        TextView result_Q5 = findViewById(R.id.q5_result_text);
        TextView result_Q6 = findViewById(R.id.q6_result_text);
        TextView result_Q7 = findViewById(R.id.q7_result_text);
        TextView result_Q8 = findViewById(R.id.q8_result_text);
        TextView result_Q9 = findViewById(R.id.q9_result_text);
        TextView result_Q10 = findViewById(R.id.q10_result_text);
        TextView result_Q11 = findViewById(R.id.q11_result_text);
        TextView result_Q12 = findViewById(R.id.q12_result_text);

        switch (questionNum) {
            case "Q1":
                result_Q1.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q1.setText(getResources().getString(R.string.result_correct_text));
                result_Q1.setVisibility(View.VISIBLE);
                break;
            case "Q2":
                result_Q2.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q2.setText(getResources().getString(R.string.result_correct_text));
                result_Q2.setVisibility(View.VISIBLE);
                break;
            case "Q3":
                result_Q3.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q3.setText(getResources().getString(R.string.result_correct_text));
                result_Q3.setVisibility(View.VISIBLE);
                break;
            case "Q4":
                result_Q4.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q4.setText(getResources().getString(R.string.result_correct_text));
                result_Q4.setVisibility(View.VISIBLE);
                break;
            case "Q5":
                result_Q5.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q5.setText(getResources().getString(R.string.result_correct_text));
                result_Q5.setVisibility(View.VISIBLE);
                break;
            case "Q6":
                result_Q6.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q6.setText(getResources().getString(R.string.result_correct_text));
                result_Q6.setVisibility(View.VISIBLE);
                break;
            case "Q7":
                result_Q7.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q7.setText(getResources().getString(R.string.result_correct_text));
                result_Q7.setVisibility(View.VISIBLE);
                break;
            case "Q8":
                result_Q8.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q8.setText(getResources().getString(R.string.result_correct_text));
                result_Q8.setVisibility(View.VISIBLE);
                break;
            case "Q9":
                result_Q9.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q9.setText(getResources().getString(R.string.result_correct_text));
                result_Q9.setVisibility(View.VISIBLE);
                break;
            case "Q10":
                result_Q10.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q10.setText(getResources().getString(R.string.result_correct_text));
                result_Q10.setVisibility(View.VISIBLE);
                break;
            case "Q11":
                result_Q11.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q11.setText(getResources().getString(R.string.result_correct_text));
                result_Q11.setVisibility(View.VISIBLE);
                break;
            case "Q12":
                result_Q12.setBackgroundColor(getResources().getColor(R.color.correctColor));
                result_Q12.setText(getResources().getString(R.string.result_correct_text));
                result_Q12.setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * This method will display a message highlighted in red to indicate that
     * the specified question number has been answered incorrectly. In cases
     * where data entry is requested, the correct answer will also be provided.
     *
     * @param questionNum String referring to the question number passed in
     *                    the form, "Qx" where x is an integer 1-12.
     */
    public void displayIncorrectResult(String questionNum) {
        TextView result_Q1 = findViewById(R.id.q1_result_text);
        TextView result_Q2 = findViewById(R.id.q2_result_text);
        TextView result_Q3 = findViewById(R.id.q3_result_text);
        TextView result_Q4 = findViewById(R.id.q4_result_text);
        TextView result_Q5 = findViewById(R.id.q5_result_text);
        TextView result_Q6 = findViewById(R.id.q6_result_text);
        TextView result_Q7 = findViewById(R.id.q7_result_text);
        TextView result_Q8 = findViewById(R.id.q8_result_text);
        TextView result_Q9 = findViewById(R.id.q9_result_text);
        TextView result_Q10 = findViewById(R.id.q10_result_text);
        TextView result_Q11 = findViewById(R.id.q11_result_text);
        TextView result_Q12 = findViewById(R.id.q12_result_text);

        switch (questionNum) {
            case "Q1":
                String incorrect_Q1 = getResources().getString(R.string.result_incorrect_text) +
                        "\n" + getResources().getString(R.string.correct_answer_text) +
                        " " + getResources().getString(R.string.question01_answer);

                result_Q1.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q1.setText(incorrect_Q1);
                result_Q1.setVisibility(View.VISIBLE);
                break;
            case "Q2":
                String incorrect_Q2 = getResources().getString(R.string.result_incorrect_text);

                result_Q2.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q2.setText(incorrect_Q2);
                result_Q2.setVisibility(View.VISIBLE);
                break;
            case "Q3":
                String incorrect_Q3 = getResources().getString(R.string.result_incorrect_text);

                result_Q3.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q3.setText(incorrect_Q3);
                result_Q3.setVisibility(View.VISIBLE);
                break;
            case "Q4":
                String incorrect_Q4 = getResources().getString(R.string.result_incorrect_text);

                result_Q4.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q4.setText(incorrect_Q4);
                result_Q4.setVisibility(View.VISIBLE);
                break;
            case "Q5":
                String incorrect_Q5 = getResources().getString(R.string.result_incorrect_text);
                incorrect_Q5 = incorrect_Q5 + "\n" + getResources().getString(R.string.correct_answer_text);
                incorrect_Q5 = incorrect_Q5 + "\n" + getResources().getString(R.string.q5_textbox1_hint) +
                        " " + getResources().getString(R.string.question05_answer_gate);
                incorrect_Q5 = incorrect_Q5 + "\n" + getResources().getString(R.string.q5_textbox2_hint) +
                        " " + getResources().getString(R.string.question05_answer_flight);

                result_Q5.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q5.setText(incorrect_Q5);
                result_Q5.setVisibility(View.VISIBLE);
                break;
            case "Q6":
                String incorrect_Q6 = getResources().getString(R.string.result_incorrect_text);

                result_Q6.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q6.setText(incorrect_Q6);
                result_Q6.setVisibility(View.VISIBLE);
                break;
            case "Q7":
                String incorrect_Q7 = getResources().getString(R.string.result_incorrect_text) +
                        "\n" + getResources().getString(R.string.correct_answer_text) +
                        " " + getResources().getString(R.string.question07_answer);

                result_Q7.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q7.setText(incorrect_Q7);
                result_Q7.setVisibility(View.VISIBLE);
                break;
            case "Q8":
                String incorrect_Q8 = getResources().getString(R.string.result_incorrect_text);

                result_Q8.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q8.setText(incorrect_Q8);
                result_Q8.setVisibility(View.VISIBLE);
                break;
            case "Q9":
                String incorrect_Q9 = getResources().getString(R.string.result_incorrect_text);

                result_Q9.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q9.setText(incorrect_Q9);
                result_Q9.setVisibility(View.VISIBLE);
                break;
            case "Q10":
                String incorrect_Q10 = getResources().getString(R.string.result_incorrect_text);

                result_Q10.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q10.setText(incorrect_Q10);
                result_Q10.setVisibility(View.VISIBLE);
                break;
            case "Q11":
                String incorrect_Q11 = getResources().getString(R.string.result_incorrect_text);

                result_Q11.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q11.setText(incorrect_Q11);
                result_Q11.setVisibility(View.VISIBLE);
                break;
            case "Q12":
                String incorrect_Q12 = getResources().getString(R.string.result_incorrect_text);

                result_Q12.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                result_Q12.setText(incorrect_Q12);
                result_Q12.setVisibility(View.VISIBLE);
                break;
        }
    }


    /**
     * This method is called to display the score attained by the user on the
     * quiz once the answers have been verified.
     *
     * @param quizScoreTotal The number of correct answers calculated based on
     */
    public void displayScore(int quizScoreTotal) {
        String quiz_result_msg;
        Button submit_button = findViewById(R.id.submit_button);

        submit_button.setFocusable(true);
        submit_button.setFocusableInTouchMode(true);
        submit_button.requestFocus();

        if (quizScoreTotal == 12) {
            quiz_result_msg = getString(R.string.congrats);
        } else if (quizScoreTotal < 12 && quizScoreTotal >= 9) {
            quiz_result_msg = getString(R.string.good_job);
        } else {
            quiz_result_msg = getString(R.string.try_again);
        }

        quiz_result_msg += " " + getString(R.string.result_msg_score) + " ";
        quiz_result_msg += quizScoreTotal + " / " + max_score + ".";

        //Display result message in a Toast
        Toast.makeText(getApplicationContext(), quiz_result_msg, Toast.LENGTH_LONG).show();

    }


    /**
     * This method is called when the 'Reset' button is clicked to clear all
     * text entered, answers selected, highlighted answers, and quiz results.
     *
     * @param view default parameter, optional
     */
    public void resetQuiz(View view) {
        removeHighlighting();
        resetQuizScores();

        //Clear Question 1
        EditText guess_Q1 = findViewById(R.id.q1_textbox);
        TextView result_Q1 = findViewById(R.id.q1_result_text);

        guess_Q1.setText("");
        result_Q1.setVisibility(View.GONE);

        //Clear Question 2
        RadioGroup q2_Answers = findViewById(R.id.q2_radioGroup);
        TextView result_Q2 = findViewById(R.id.q2_result_text);

        q2_Answers.clearCheck();
        result_Q2.setVisibility(View.GONE);

        //Clear Question 3 checkboxes
        CheckBox q3_chkbox1 = findViewById(R.id.q3_check_guess1);
        CheckBox q3_chkbox2 = findViewById(R.id.q3_check_guess2);
        CheckBox q3_chkbox3 = findViewById(R.id.q3_check_guess3);
        CheckBox q3_chkbox4 = findViewById(R.id.q3_check_guess4);
        TextView result_Q3 = findViewById(R.id.q3_result_text);

        if (q3_chkbox1.isChecked()) {
            q3_chkbox1.toggle();
        }

        if (q3_chkbox2.isChecked()) {
            q3_chkbox2.toggle();
        }

        if (q3_chkbox3.isChecked()) {
            q3_chkbox3.toggle();
        }

        if (q3_chkbox4.isChecked()) {
            q3_chkbox4.toggle();
        }

        result_Q3.setVisibility(View.GONE);

        //Clear Question 4
        RadioGroup q4_Answers = findViewById(R.id.q4_radioGroup);
        TextView result_Q4 = findViewById(R.id.q4_result_text);

        q4_Answers.clearCheck();
        result_Q4.setVisibility(View.GONE);

        //Clear Question 5
        EditText gateGuess_Q5 = findViewById(R.id.q5_textbox1);
        TextView result_Q5 = findViewById(R.id.q5_result_text);
        EditText flightGuess_Q5 = findViewById(R.id.q5_textbox2);

        gateGuess_Q5.setText("");
        flightGuess_Q5.setText("");
        result_Q5.setVisibility(View.GONE);

        //Clear Question 6
        RadioGroup q6_Answers = findViewById(R.id.q6_radioGroup);
        TextView result_Q6 = findViewById(R.id.q6_result_text);

        q6_Answers.clearCheck();
        result_Q6.setVisibility(View.GONE);

        //Clear Question 7
        EditText guess_Q7 = findViewById(R.id.q7_textbox);
        TextView result_Q7 = findViewById(R.id.q7_result_text);

        guess_Q7.setText("");
        result_Q7.setVisibility(View.GONE);

        //Clear Question 8
        RadioGroup q8_Answers = findViewById(R.id.q8_radioGroup);
        TextView result_Q8 = findViewById(R.id.q8_result_text);

        q8_Answers.clearCheck();
        result_Q8.setVisibility(View.GONE);

        //Clear Question 9
        RadioGroup q9_Answers = findViewById(R.id.q9_radioGroup);
        TextView result_Q9 = findViewById(R.id.q9_result_text);

        q9_Answers.clearCheck();
        result_Q9.setVisibility(View.GONE);

        //Clear Question 10
        RadioGroup q10_Answers = findViewById(R.id.q10_radioGroup);
        TextView result_Q10 = findViewById(R.id.q10_result_text);

        q10_Answers.clearCheck();
        result_Q10.setVisibility(View.GONE);

        //Clear Question 11 checkboxes
        CheckBox q11_chkbox1 = findViewById(R.id.q11_check_guess1);
        CheckBox q11_chkbox2 = findViewById(R.id.q11_check_guess2);
        CheckBox q11_chkbox3 = findViewById(R.id.q11_check_guess3);
        CheckBox q11_chkbox4 = findViewById(R.id.q11_check_guess4);
        TextView result_Q11 = findViewById(R.id.q11_result_text);

        if (q11_chkbox1.isChecked()) {
            q11_chkbox1.toggle();
        }

        if (q11_chkbox2.isChecked()) {
            q11_chkbox2.toggle();
        }

        if (q11_chkbox3.isChecked()) {
            q11_chkbox3.toggle();
        }

        if (q11_chkbox4.isChecked()) {
            q11_chkbox4.toggle();
        }

        result_Q11.setVisibility(View.GONE);

        //Clear Question 12
        RadioGroup q12_Answers = findViewById(R.id.q12_radioGroup);
        TextView result_Q12 = findViewById(R.id.q12_result_text);

        q12_Answers.clearCheck();
        result_Q12.setVisibility(View.GONE);

    }

    /**
     * Removes highlighting of correct answers to each question that was
     * answered incorrectly. Called when Submit or Reset button is clicked.
     */
    public void removeHighlighting() {
        RadioButton q2_correct_answer = findViewById(R.id.q2_radio_answer);
        CheckBox q3_chkbox1 = findViewById(R.id.q3_check_guess1);
        CheckBox q3_chkbox2 = findViewById(R.id.q3_check_guess2);
        CheckBox q3_chkbox3 = findViewById(R.id.q3_check_guess3);
        CheckBox q3_chkbox4 = findViewById(R.id.q3_check_guess4);
        RadioButton q4_correct_answer = findViewById(R.id.q4_radio3);
        RadioButton q6_correct_answer = findViewById(R.id.q6_radio1);
        RadioButton q8_correct_answer = findViewById(R.id.q8_radio1);
        RadioButton q9_correct_answer = findViewById(R.id.q9_radio4);
        RadioButton q10_correct_answer = findViewById(R.id.q10_radio1);
        CheckBox q11_chkbox2 = findViewById(R.id.q11_check_guess2);
        CheckBox q11_chkbox3 = findViewById(R.id.q11_check_guess3);
        CheckBox q11_chkbox4 = findViewById(R.id.q11_check_guess4);
        RadioButton q12_correct_answer = findViewById(R.id.q12_radio4);

        q2_correct_answer.setBackgroundColor(Color.TRANSPARENT);
        q3_chkbox1.setBackgroundColor(Color.TRANSPARENT);
        q3_chkbox2.setBackgroundColor(Color.TRANSPARENT);
        q3_chkbox3.setBackgroundColor(Color.TRANSPARENT);
        q3_chkbox4.setBackgroundColor(Color.TRANSPARENT);
        q4_correct_answer.setBackgroundColor(Color.TRANSPARENT);
        q6_correct_answer.setBackgroundColor(Color.TRANSPARENT);
        q8_correct_answer.setBackgroundColor(Color.TRANSPARENT);
        q9_correct_answer.setBackgroundColor(Color.TRANSPARENT);
        q10_correct_answer.setBackgroundColor(Color.TRANSPARENT);
        q11_chkbox2.setBackgroundColor(Color.TRANSPARENT);
        q11_chkbox3.setBackgroundColor(Color.TRANSPARENT);
        q11_chkbox4.setBackgroundColor(Color.TRANSPARENT);
        q12_correct_answer.setBackgroundColor(Color.TRANSPARENT);

    }


    /**
     * This method is called when the Submit or Reest button is clicked
     * so the quiz score can be properly calculated.
     */
    public void resetQuizScores() {
        //clear quiz score
        quiz_score = 0;

        //clear sub scores
        q3_sub_score = 0;
        q5_sub_score = 0;
        q11_sub_score = 0;
    }


}
