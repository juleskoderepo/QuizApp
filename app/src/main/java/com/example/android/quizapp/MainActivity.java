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

    EditText q1Guess;
    TextView q1Result;
    RadioGroup q2RadioGrp;
    RadioButton q2CorrectAnswer;
    TextView q2Result;
    CheckBox q3CB1;
    CheckBox q3CB2;
    CheckBox q3CB3;
    CheckBox q3CB4;
    TextView q3Result;
    RadioGroup q4RadioGrp;
    RadioButton q4CorrectAnswer;
    TextView q4Result;
    EditText q5GateGuess;
    EditText q5FltGuess;
    TextView q5Result;
    RadioGroup q6RadioGrp;
    RadioButton q6CorrectAnswer;
    TextView q6Result;
    EditText q7Guess;
    TextView q7Result;
    RadioGroup q8RadioGrp;
    RadioButton q8CorrectAnswer;
    TextView q8Result;
    RadioGroup q9RadioGrp;
    RadioButton q9CorrectAnswer;
    TextView q9Result;
    RadioGroup q10RadioGrp;
    RadioButton q10CorrectAnswer;
    TextView q10Result;
    CheckBox q11CB1;
    CheckBox q11CB2;
    CheckBox q11CB3;
    CheckBox q11CB4;
    TextView q11Result;
    RadioGroup q12RadioGrp;
    RadioButton q12CorrectAnswer;
    TextView q12Result;

    public static final String KEY_savedTextQ1 = "savedGuessQ1";
    public static final String KEY_savedGateTextQ5 = "savedGateGuessQ5";
    public static final String KEY_savedFltTextQ5 = "savedFltGuessQ5";
    public static final String KEY_savedTextQ7 = "savedGuessQ7";
    public static final String KEY_savedScore = "savedQuizScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1Guess = findViewById(R.id.q1_textbox);
        q1Result = findViewById(R.id.q1_result_text);
        q2RadioGrp = findViewById(R.id.q2_radioGroup);
        q2CorrectAnswer = findViewById(R.id.q2_radio_answer);
        q2Result = findViewById(R.id.q2_result_text);
        q3CB1 = findViewById(R.id.q3_check_guess1);
        q3CB2 = findViewById(R.id.q3_check_guess2);
        q3CB3 = findViewById(R.id.q3_check_guess3);
        q3CB4 = findViewById(R.id.q3_check_guess4);
        q3Result = findViewById(R.id.q3_result_text);
        q4RadioGrp = findViewById(R.id.q4_radioGroup);
        q4CorrectAnswer = findViewById(R.id.q4_radio3);
        q4Result = findViewById(R.id.q4_result_text);
        q5GateGuess = findViewById(R.id.q5_textbox1);
        q5FltGuess = findViewById(R.id.q5_textbox2);
        q5Result = findViewById(R.id.q5_result_text);
        q6RadioGrp = findViewById(R.id.q6_radioGroup);
        q6CorrectAnswer = findViewById(R.id.q6_radio1);
        q6Result = findViewById(R.id.q6_result_text);
        q7Guess = findViewById(R.id.q7_textbox);
        q7Result = findViewById(R.id.q7_result_text);
        q8RadioGrp = findViewById(R.id.q8_radioGroup);
        q8CorrectAnswer = findViewById(R.id.q8_radio1);
        q8Result = findViewById(R.id.q8_result_text);
        q9RadioGrp = findViewById(R.id.q9_radioGroup);
        q9CorrectAnswer = findViewById(R.id.q9_radio4);
        q9Result = findViewById(R.id.q9_result_text);
        q10RadioGrp = findViewById(R.id.q10_radioGroup);
        q10CorrectAnswer = findViewById(R.id.q10_radio1);
        q10Result = findViewById(R.id.q10_result_text);
        q11CB1 = findViewById(R.id.q11_check_guess1);
        q11CB2 = findViewById(R.id.q11_check_guess2);
        q11CB3 = findViewById(R.id.q11_check_guess3);
        q11CB4 = findViewById(R.id.q11_check_guess4);
        q11Result = findViewById(R.id.q11_result_text);
        q12RadioGrp = findViewById(R.id.q12_radioGroup);
        q12CorrectAnswer = findViewById(R.id.q12_radio4);
        q12Result = findViewById(R.id.q12_result_text);
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
        savedInstanceState.putCharSequence(KEY_savedTextQ1, guessText_Q1);

        final EditText gate_guess_Q5 = findViewById(R.id.q5_textbox1);
        CharSequence gate_text_Q5 = gate_guess_Q5.getText();
        savedInstanceState.putCharSequence(KEY_savedGateTextQ5, gate_text_Q5);

        final EditText flt_guess_Q5 = findViewById(R.id.q5_textbox2);
        CharSequence flt_text_Q5 = flt_guess_Q5.getText();
        savedInstanceState.putCharSequence(KEY_savedFltTextQ5, flt_text_Q5);

        final EditText guess_Q7 = findViewById(R.id.q7_textbox);
        CharSequence guessText_Q7 = guess_Q7.getText();
        savedInstanceState.putCharSequence(KEY_savedTextQ7, guessText_Q7);


        //save quiz score
        savedInstanceState.putInt(KEY_savedScore, quiz_score);

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
        CharSequence guessText_Q1 = savedInstanceState.getCharSequence(KEY_savedTextQ1);
        guess_Q1.setText(guessText_Q1);

        final EditText gate_guess_Q5 = findViewById(R.id.q5_textbox1);
        CharSequence gate_text_Q5 = savedInstanceState.getCharSequence(KEY_savedGateTextQ5);
        gate_guess_Q5.setText(gate_text_Q5);

        final EditText flt_guess_Q5 = findViewById(R.id.q5_textbox2);
        CharSequence flt_text_Q5 = savedInstanceState.getCharSequence(KEY_savedFltTextQ5);
        flt_guess_Q5.setText(flt_text_Q5);

        final EditText guess_Q7 = findViewById(R.id.q7_textbox);
        CharSequence guessText_Q7 = savedInstanceState.getCharSequence(KEY_savedTextQ7);
        guess_Q7.setText(guessText_Q7);


        //restore quiz score
        quiz_score = savedInstanceState.getInt(KEY_savedScore);
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
        String q1Text = q1Guess.getText().toString();

        //capitalize first letter of guess for comparison to correct answer
        if (q1Text.trim().length() > 1) {
            q1Text = q1Text.substring(0, 1).toUpperCase() + q1Text.substring(1).toLowerCase();
        }

        if (q1Text.equals(getString(R.string.question01_answer))) {
            quiz_score += 1;
            displayCorrectResult("Q1");
        } else {
            displayIncorrectResult("Q1");
        }

        //check answer to Question 2
        if (q2CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q2");
        } else {
            displayIncorrectResult("Q2");
            q2CorrectAnswer.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 3
        if (q3CB1.isChecked()) {
            q3_sub_score += .25;
        }

        if (q3CB2.isChecked()) {
            q3_sub_score += .25;
        }

        if (q3CB3.isChecked()) {
            q3_sub_score += .25;
        }

        if (q3CB4.isChecked()) {
            q3_sub_score += .25;
        }

        if (q3_sub_score == 1.0) {
            quiz_score += 1;
            displayCorrectResult("Q3");
        } else {
            displayIncorrectResult("Q3");

            q3CB1.setBackgroundResource(R.color.correctColor);
            q3CB2.setBackgroundResource(R.color.correctColor);
            q3CB3.setBackgroundResource(R.color.correctColor);
            q3CB4.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 4
        if (q4CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q4");
        } else {
            displayIncorrectResult("Q4");
            q4CorrectAnswer.setBackgroundResource(R.color.correctColor);
        }

        //check answers to Question 5
        //check gate answer
        String q5GateText = q5GateGuess.getText().toString();
        if (q5GateText.equals(getString(R.string.question05_answer_gate))) {
            q5_sub_score += .5;
        }

        //check flight answer
        String q5FlightText = q5FltGuess.getText().toString();
        if (q5FlightText.equals(getString(R.string.question05_answer_flight))) {
            q5_sub_score += .5;
        }

        if (q5_sub_score == 1.0) {
            quiz_score += 1;
            displayCorrectResult("Q5");
        } else {
            displayIncorrectResult("Q5");
        }

        //check answer to Question 6
        if (q6CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q6");
        } else {
            displayIncorrectResult("Q6");
            q6CorrectAnswer.setBackgroundResource(R.color.correctColor);
        }


        //check answer to Question 7
        String q7Text = q7Guess.getText().toString();

        if (q7Text.equals(getString(R.string.question07_answer))) {
            quiz_score += 1;
            displayCorrectResult("Q7");
        } else {
            displayIncorrectResult("Q7");
        }

        //check answer to Question 8
        if (q8CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q8");
        } else {
            displayIncorrectResult("Q8");
            q8CorrectAnswer.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 9
        if (q9CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q9");
        } else {
            displayIncorrectResult("Q9");
            q9CorrectAnswer.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 10
        if (q10CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q10");
        } else {
            displayIncorrectResult("Q10");
            q10CorrectAnswer.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 11
        if (q11CB1.isChecked()) {
            q11_sub_score += -1;
        }

        if (q11CB2.isChecked()) {
            q11_sub_score += .333;
        }

        if (q11CB3.isChecked()) {
            q11_sub_score += .333;
        }

        if (q11CB4.isChecked()) {
            q11_sub_score += .334;
        }

        if (q11_sub_score == 1.0) {
            quiz_score += 1;
            displayCorrectResult("Q11");
        } else {
            displayIncorrectResult("Q11");
            q11CB2.setBackgroundResource(R.color.correctColor);
            q11CB3.setBackgroundResource(R.color.correctColor);
            q11CB4.setBackgroundResource(R.color.correctColor);
        }

        //check answer to Question 12
        if (q12CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayCorrectResult("Q12");
        } else {
            displayIncorrectResult("Q12");
            q12CorrectAnswer.setBackgroundResource(R.color.correctColor);
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
        switch (questionNum) {
            case "Q1":
                q1Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q1Result.setText(getResources().getString(R.string.result_correct_text));
                q1Result.setVisibility(View.VISIBLE);
                break;
            case "Q2":
                q2Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q2Result.setText(getResources().getString(R.string.result_correct_text));
                q2Result.setVisibility(View.VISIBLE);
                break;
            case "Q3":
                q3Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q3Result.setText(getResources().getString(R.string.result_correct_text));
                q3Result.setVisibility(View.VISIBLE);
                break;
            case "Q4":
                q4Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q4Result.setText(getResources().getString(R.string.result_correct_text));
                q4Result.setVisibility(View.VISIBLE);
                break;
            case "Q5":
                q5Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q5Result.setText(getResources().getString(R.string.result_correct_text));
                q5Result.setVisibility(View.VISIBLE);
                break;
            case "Q6":
                q6Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q6Result.setText(getResources().getString(R.string.result_correct_text));
                q6Result.setVisibility(View.VISIBLE);
                break;
            case "Q7":
                q7Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q7Result.setText(getResources().getString(R.string.result_correct_text));
                q7Result.setVisibility(View.VISIBLE);
                break;
            case "Q8":
                q8Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q8Result.setText(getResources().getString(R.string.result_correct_text));
                q8Result.setVisibility(View.VISIBLE);
                break;
            case "Q9":
                q9Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q9Result.setText(getResources().getString(R.string.result_correct_text));
                q9Result.setVisibility(View.VISIBLE);
                break;
            case "Q10":
                q10Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q10Result.setText(getResources().getString(R.string.result_correct_text));
                q10Result.setVisibility(View.VISIBLE);
                break;
            case "Q11":
                q11Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q11Result.setText(getResources().getString(R.string.result_correct_text));
                q11Result.setVisibility(View.VISIBLE);
                break;
            case "Q12":
                q12Result.setBackgroundColor(getResources().getColor(R.color.correctColor));
                q12Result.setText(getResources().getString(R.string.result_correct_text));
                q12Result.setVisibility(View.VISIBLE);
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
        switch (questionNum) {
            case "Q1":
                String incorrect_Q1 = getResources().getString(R.string.result_incorrect_text) +
                        "\n" + getResources().getString(R.string.correct_answer_text) +
                        " " + getResources().getString(R.string.question01_answer);

                q1Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q1Result.setText(incorrect_Q1);
                q1Result.setVisibility(View.VISIBLE);
                break;
            case "Q2":
                String incorrect_Q2 = getResources().getString(R.string.result_incorrect_text);

                q2Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q2Result.setText(incorrect_Q2);
                q2Result.setVisibility(View.VISIBLE);
                break;
            case "Q3":
                String incorrect_Q3 = getResources().getString(R.string.result_incorrect_text);

                q3Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q3Result.setText(incorrect_Q3);
                q3Result.setVisibility(View.VISIBLE);
                break;
            case "Q4":
                String incorrect_Q4 = getResources().getString(R.string.result_incorrect_text);

                q4Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q4Result.setText(incorrect_Q4);
                q4Result.setVisibility(View.VISIBLE);
                break;
            case "Q5":
                String incorrect_Q5 = getResources().getString(R.string.result_incorrect_text);
                incorrect_Q5 = incorrect_Q5 + "\n" + getResources().getString(R.string.correct_answer_text);
                incorrect_Q5 = incorrect_Q5 + "\n" + getResources().getString(R.string.q5_textbox1_hint) +
                        " " + getResources().getString(R.string.question05_answer_gate);
                incorrect_Q5 = incorrect_Q5 + "\n" + getResources().getString(R.string.q5_textbox2_hint) +
                        " " + getResources().getString(R.string.question05_answer_flight);

                q5Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q5Result.setText(incorrect_Q5);
                q5Result.setVisibility(View.VISIBLE);
                break;
            case "Q6":
                String incorrect_Q6 = getResources().getString(R.string.result_incorrect_text);

                q6Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q6Result.setText(incorrect_Q6);
                q6Result.setVisibility(View.VISIBLE);
                break;
            case "Q7":
                String incorrect_Q7 = getResources().getString(R.string.result_incorrect_text) +
                        "\n" + getResources().getString(R.string.correct_answer_text) +
                        " " + getResources().getString(R.string.question07_answer);

                q7Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q7Result.setText(incorrect_Q7);
                q7Result.setVisibility(View.VISIBLE);
                break;
            case "Q8":
                String incorrect_Q8 = getResources().getString(R.string.result_incorrect_text);

                q8Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q8Result.setText(incorrect_Q8);
                q8Result.setVisibility(View.VISIBLE);
                break;
            case "Q9":
                String incorrect_Q9 = getResources().getString(R.string.result_incorrect_text);

                q9Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q9Result.setText(incorrect_Q9);
                q9Result.setVisibility(View.VISIBLE);
                break;
            case "Q10":
                String incorrect_Q10 = getResources().getString(R.string.result_incorrect_text);

                q10Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q10Result.setText(incorrect_Q10);
                q10Result.setVisibility(View.VISIBLE);
                break;
            case "Q11":
                String incorrect_Q11 = getResources().getString(R.string.result_incorrect_text);

                q11Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q11Result.setText(incorrect_Q11);
                q11Result.setVisibility(View.VISIBLE);
                break;
            case "Q12":
                String incorrect_Q12 = getResources().getString(R.string.result_incorrect_text);

                q12Result.setBackgroundColor(getResources().getColor(R.color.incorrectColor));
                q12Result.setText(incorrect_Q12);
                q12Result.setVisibility(View.VISIBLE);
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
        q1Guess.setText("");
        q1Result.setVisibility(View.GONE);

        //Clear Question 2
        q2RadioGrp.clearCheck();
        q2Result.setVisibility(View.GONE);

        //Clear Question 3 checkboxes
        if (q3CB1.isChecked()) {
            q3CB1.toggle();
        }

        if (q3CB2.isChecked()) {
            q3CB2.toggle();
        }

        if (q3CB3.isChecked()) {
            q3CB3.toggle();
        }

        if (q3CB4.isChecked()) {
            q3CB4.toggle();
        }

        q3Result.setVisibility(View.GONE);

        //Clear Question 4
        q4RadioGrp.clearCheck();
        q4Result.setVisibility(View.GONE);

        //Clear Question 5
        q5GateGuess.setText("");
        q5FltGuess.setText("");
        q5Result.setVisibility(View.GONE);

        //Clear Question 6
        q6RadioGrp.clearCheck();
        q6Result.setVisibility(View.GONE);

        //Clear Question 7
        q7Guess.setText("");
        q7Result.setVisibility(View.GONE);

        //Clear Question 8
        q8RadioGrp.clearCheck();
        q8Result.setVisibility(View.GONE);

        //Clear Question 9
        q9RadioGrp.clearCheck();
        q9Result.setVisibility(View.GONE);

        //Clear Question 10
        q10RadioGrp.clearCheck();
        q10Result.setVisibility(View.GONE);

        //Clear Question 11 checkboxes
        if (q11CB1.isChecked()) {
            q11CB1.toggle();
        }

        if (q11CB2.isChecked()) {
            q11CB2.toggle();
        }

        if (q11CB3.isChecked()) {
            q11CB3.toggle();
        }

        if (q11CB4.isChecked()) {
            q11CB4.toggle();
        }

        q11Result.setVisibility(View.GONE);

        //Clear Question 12
        q12RadioGrp.clearCheck();
        q12Result.setVisibility(View.GONE);

    }

    /**
     * Removes highlighting of correct answers to each question that was
     * answered incorrectly. Called when Submit or Reset button is clicked.
     */
    public void removeHighlighting() {
        q2CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q3CB1.setBackgroundColor(Color.TRANSPARENT);
        q3CB2.setBackgroundColor(Color.TRANSPARENT);
        q3CB3.setBackgroundColor(Color.TRANSPARENT);
        q3CB4.setBackgroundColor(Color.TRANSPARENT);
        q4CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q6CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q8CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q9CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q10CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q11CB2.setBackgroundColor(Color.TRANSPARENT);
        q11CB3.setBackgroundColor(Color.TRANSPARENT);
        q11CB4.setBackgroundColor(Color.TRANSPARENT);
        q12CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);

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
