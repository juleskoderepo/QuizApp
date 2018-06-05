package com.example.android.quizapp;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizapp.R.drawable.textbox_correct;
import static com.example.android.quizapp.R.drawable.textbox_transparent;

public class MainActivity extends AppCompatActivity {
    int quiz_score = 0;
    final int max_score = 8;
    int score_calculated = 0; //flag to indicate the quiz score has been calculated

    RadioGroup q1RadioGrp;
    RadioButton q1CorrectAnswer;
    TextView q1Result;
    CharSequence q1ResultText;
    int q1ResultTextColor;
    int q1ResultVisibility;
    CheckBox q2CB1;
    CheckBox q2CB2;
    CheckBox q2CB3;
    CheckBox q2CB4;
    TextView q2Result;
    CharSequence q2ResultText;
    int q2ResultTextColor;
    int q2ResultVisibility;
    RadioGroup q3RadioGrp;
    RadioButton q3CorrectAnswer;
    TextView q3Result;
    CharSequence q3ResultText;
    int q3ResultTextColor;
    int q3ResultVisibility;
    RadioGroup q4RadioGrp;
    RadioButton q4CorrectAnswer;
    TextView q4Result;
    CharSequence q4ResultText;
    int q4ResultTextColor;
    int q4ResultVisibility;
    EditText q5Guess;
    CharSequence q5Text;
    TextView q5Result;
    CharSequence q5ResultText;
    int q5ResultTextColor;
    int q5ResultVisibility;
    RadioGroup q6RadioGrp;
    RadioButton q6CorrectAnswer;
    TextView q6Result;
    CharSequence q6ResultText;
    int q6ResultTextColor;
    int q6ResultVisibility;
    CheckBox q7CB1;
    CheckBox q7CB2;
    CheckBox q7CB3;
    CheckBox q7CB4;
    TextView q7Result;
    CharSequence q7ResultText;
    int q7ResultTextColor;
    int q7ResultVisibility;
    RadioGroup q8RadioGrp;
    RadioButton q8CorrectAnswer;
    TextView q8Result;
    CharSequence q8ResultText;
    int q8ResultTextColor;
    int q8ResultVisibility;


    public static final String KEY_savedQ5Text = "savedQ5Guess";
    public static final String KEY_savedScore = "savedQuizScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1RadioGrp = findViewById(R.id.q1_radioGroup);
        q1CorrectAnswer = findViewById(R.id.q1_radio3_answer);
        q1Result = findViewById(R.id.q1_result_text);
        q2CB1 = findViewById(R.id.q2_check1_answer);
        q2CB2 = findViewById(R.id.q2_check2_answer);
        q2CB3 = findViewById(R.id.q2_check3_answer);
        q2CB4 = findViewById(R.id.q2_check4_answer);
        q2Result = findViewById(R.id.q2_result_text);
        q3RadioGrp = findViewById(R.id.q3_radioGroup);
        q3CorrectAnswer = findViewById(R.id.q3_radio2_answer);
        q3Result = findViewById(R.id.q3_result_text);
        q4RadioGrp = findViewById(R.id.q4_radioGroup);
        q4CorrectAnswer = findViewById(R.id.q4_radio1_answer);
        q4Result = findViewById(R.id.q4_result_text);
        q5Guess = findViewById(R.id.q5_textbox);
        q5Result = findViewById(R.id.q5_result_text);
        q6RadioGrp = findViewById(R.id.q6_radioGroup);
        q6CorrectAnswer = findViewById(R.id.q6_radio1_answer);
        q6Result = findViewById(R.id.q6_result_text);
        q7CB1 = findViewById(R.id.q7_check1_guess);
        q7CB2 = findViewById(R.id.q7_check2_answer);
        q7CB3 = findViewById(R.id.q7_check3_answer);
        q7CB4 = findViewById(R.id.q7_check4_answer);
        q7Result = findViewById(R.id.q7_result_text);
        q8RadioGrp = findViewById(R.id.q8_radioGroup);
        q8CorrectAnswer = findViewById(R.id.q8_radio3_answer);
        q8Result = findViewById(R.id.q8_result_text);
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

        //save state of results and text entered
        q1ResultText = q1Result.getText();
        q1ResultTextColor = q1Result.getCurrentTextColor();
        q1ResultVisibility = q1Result.getVisibility();
        q2ResultText = q2Result.getText();
        q2ResultTextColor = q2Result.getCurrentTextColor();
        q2ResultVisibility = q2Result.getVisibility();
        q3ResultText = q3Result.getText();
        q3ResultTextColor = q3Result.getCurrentTextColor();
        q3ResultVisibility = q3Result.getVisibility();
        q4ResultText = q4Result.getText();
        q4ResultTextColor = q4Result.getCurrentTextColor();
        q4ResultVisibility = q4Result.getVisibility();
        q5Text = q5Guess.getText(); //save answer in text box
        q5ResultText = q5Result.getText();
        q5ResultTextColor = q5Result.getCurrentTextColor();
        q5ResultVisibility = q5Result.getVisibility();
        q6ResultText = q6Result.getText();
        q6ResultTextColor = q6Result.getCurrentTextColor();
        q6ResultVisibility = q6Result.getVisibility();
        q7ResultText = q7Result.getText();
        q7ResultTextColor = q7Result.getCurrentTextColor();
        q7ResultVisibility = q7Result.getVisibility();
        q8ResultText = q8Result.getText();
        q8ResultTextColor = q8Result.getCurrentTextColor();
        q8ResultVisibility = q8Result.getVisibility();

        //add saved values to savedInstanceState bundle
        savedInstanceState.putCharSequence("KEY_q1ResultText", q1ResultText);
        savedInstanceState.putInt("KEY_q1ResultTextColor", q1ResultTextColor);
        savedInstanceState.putInt("KEY_q1ResultVisibility", q1ResultVisibility);
        savedInstanceState.putCharSequence("KEY_q2ResultText", q2ResultText);
        savedInstanceState.putInt("KEY_q2ResultTextColor", q2ResultTextColor);
        savedInstanceState.putInt("KEY_q2ResultVisibility", q2ResultVisibility);
        savedInstanceState.putCharSequence("KEY_q3ResultText", q3ResultText);
        savedInstanceState.putInt("KEY_q3ResultTextColor", q3ResultTextColor);
        savedInstanceState.putInt("KEY_q3ResultVisibility", q3ResultVisibility);
        savedInstanceState.putCharSequence("KEY_q4ResultText", q4ResultText);
        savedInstanceState.putInt("KEY_q4ResultTextColor", q4ResultTextColor);
        savedInstanceState.putInt("KEY_q4ResultVisibility", q4ResultVisibility);
        savedInstanceState.putCharSequence(KEY_savedQ5Text, q5Text);
        savedInstanceState.putCharSequence("KEY_q5ResultText", q5ResultText);
        savedInstanceState.putInt("KEY_q5ResultTextColor", q5ResultTextColor);
        savedInstanceState.putInt("KEY_q5ResultVisibility", q5ResultVisibility);
        savedInstanceState.putCharSequence("KEY_q6ResultText", q6ResultText);
        savedInstanceState.putInt("KEY_q6ResultTextColor", q6ResultTextColor);
        savedInstanceState.putInt("KEY_q6ResultVisibility", q6ResultVisibility);
        savedInstanceState.putCharSequence("KEY_q7ResultText", q7ResultText);
        savedInstanceState.putInt("KEY_q7ResultTextColor", q7ResultTextColor);
        savedInstanceState.putInt("KEY_q7ResultVisibility", q7ResultVisibility);
        savedInstanceState.putCharSequence("KEY_q8ResultText", q8ResultText);
        savedInstanceState.putInt("KEY_q8ResultTextColor", q8ResultTextColor);
        savedInstanceState.putInt("KEY_q8ResultVisibility", q8ResultVisibility);

        //save quiz score
        savedInstanceState.putInt(KEY_savedScore, quiz_score);

        //save score calculated flag
        savedInstanceState.putInt("KEY_scoreCalculated", score_calculated);

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

        //restore saved states of quiz questions and results
//        int colorId = savedInstanceState.getInt("KEY_savedQ1Color");
//        q1CorrectAnswer.setBackgroundResource(colorId);

        //retrieve saved values
        q1ResultText = savedInstanceState.getCharSequence("KEY_q1ResultText");
        q1ResultTextColor = savedInstanceState.getInt("KEY_q1ResultTextColor");
        q1ResultVisibility = savedInstanceState.getInt("KEY_q1ResultVisibility");
        q2ResultText = savedInstanceState.getCharSequence("KEY_q2ResultText");
        q2ResultTextColor = savedInstanceState.getInt("KEY_q2ResultTextColor");
        q2ResultVisibility = savedInstanceState.getInt("KEY_q2ResultVisibility");
        q3ResultText = savedInstanceState.getCharSequence("KEY_q3ResultText");
        q3ResultTextColor = savedInstanceState.getInt("KEY_q3ResultTextColor");
        q3ResultVisibility = savedInstanceState.getInt("KEY_q3ResultVisibility");
        q4ResultText = savedInstanceState.getCharSequence("KEY_q4ResultText");
        q4ResultTextColor = savedInstanceState.getInt("KEY_q4ResultTextColor");
        q4ResultVisibility = savedInstanceState.getInt("KEY_q4ResultVisibility");
        q5Text = savedInstanceState.getCharSequence(KEY_savedQ5Text);
        q5ResultText = savedInstanceState.getCharSequence("KEY_q5ResultText");
        q5ResultTextColor = savedInstanceState.getInt("KEY_q5ResultTextColor");
        q5ResultVisibility = savedInstanceState.getInt("KEY_q5ResultVisibility");
        q6ResultText = savedInstanceState.getCharSequence("KEY_q6ResultText");
        q6ResultTextColor = savedInstanceState.getInt("KEY_q6ResultTextColor");
        q6ResultVisibility = savedInstanceState.getInt("KEY_q6ResultVisibility");
        q6ResultText = savedInstanceState.getCharSequence("KEY_q6ResultText");
        q6ResultTextColor = savedInstanceState.getInt("KEY_q6ResultTextColor");
        q6ResultVisibility = savedInstanceState.getInt("KEY_q6ResultVisibility");
        q7ResultText = savedInstanceState.getCharSequence("KEY_q7ResultText");
        q7ResultTextColor = savedInstanceState.getInt("KEY_q7ResultTextColor");
        q7ResultVisibility = savedInstanceState.getInt("KEY_q7ResultVisibility");
        q8ResultText = savedInstanceState.getCharSequence("KEY_q8ResultText");
        q8ResultTextColor = savedInstanceState.getInt("KEY_q8ResultTextColor");
        q8ResultVisibility = savedInstanceState.getInt("KEY_q8ResultVisibility");

        //restore saved values
        q1Result.setText(q1ResultText);
        q1Result.setTextColor(q1ResultTextColor);
        q1Result.setVisibility(q1ResultVisibility);
        q2Result.setText(q2ResultText);
        q2Result.setTextColor(q2ResultTextColor);
        q2Result.setVisibility(q2ResultVisibility);
        q3Result.setText(q3ResultText);
        q3Result.setTextColor(q3ResultTextColor);
        q3Result.setVisibility(q3ResultVisibility);
        q4Result.setText(q4ResultText);
        q4Result.setTextColor(q4ResultTextColor);
        q4Result.setVisibility(q4ResultVisibility);
        q5Guess.setText(q5Text);
        q5Result.setText(q5ResultText);
        q5Result.setTextColor(q5ResultTextColor);
        q5Result.setVisibility(q5ResultVisibility);
        q6Result.setText(q6ResultText);
        q6Result.setTextColor(q6ResultTextColor);
        q6Result.setVisibility(q6ResultVisibility);
        q7Result.setText(q7ResultText);
        q7Result.setTextColor(q7ResultTextColor);
        q7Result.setVisibility(q7ResultVisibility);
        q8Result.setText(q8ResultText);
        q8Result.setTextColor(q8ResultTextColor);
        q8Result.setVisibility(q8ResultVisibility);

        //restore quiz score
        quiz_score = savedInstanceState.getInt(KEY_savedScore);

/*
        restore score calculated flag and highlight correct answers
        if condition is met.
*/
        score_calculated = savedInstanceState.getInt("KEY_scoreCalculated");
        String correct = getString(R.string.result_correct_text);

        if (score_calculated == 1) {
            highlightCorrectAnswers();

            if (q5ResultText.equals(correct)) {
                q5Guess.setBackgroundResource(textbox_correct);
            }

        }
    }

    /**
     * This method is called when the user clicks the Submit button
     * to check the answers to the quiz. In addition to validating the answers,
     * this method will tally the number of correct answers to display back to
     * the user and call other methods to display the quiz results.
     */
    public void checkAnswers(View view) {
        //re-initialize quiz score and sub-scores
        resetQuizScores();

        //reset highlighting of correct answers
        removeHighlighting();

        //check answer to Question 1
        if (q1CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayResultCorrect(q1Result);
        } else {
            displayResultIncorrect("Q1");
        }

        //check answer to Question 2
        if (q2CB1.isChecked() && q2CB2.isChecked() && q2CB3.isChecked() && q2CB4.isChecked()) {
            quiz_score += 1;
            displayResultCorrect(q2Result);
        } else {
            displayResultIncorrect("Q2");
        }

        //check answer to Question 3
        if (q3CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayResultCorrect(q3Result);
        } else {
            displayResultIncorrect("Q3");
        }

        //check answer to Question 4
        if (q4CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayResultCorrect(q4Result);
        } else {
            displayResultIncorrect("Q4");
        }

        //check answers to Question 5
        String q5Text = q5Guess.getText().toString();

        if (q5Text.equals(getString(R.string.f01_answer))) {
            quiz_score += 1;
            displayResultCorrect(q5Result);
            q5Guess.setBackgroundResource(textbox_correct);
        } else {
            displayResultIncorrect("Q5");
        }

        //check answer to Question 6
        if (q6CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayResultCorrect(q6Result);
        } else {
            displayResultIncorrect("Q6");
        }

        //check answer to Question 7
        if (!(q7CB1.isChecked()) && q7CB2.isChecked() && q7CB3.isChecked()
                && q7CB4.isChecked()) {
            quiz_score += 1;
            displayResultCorrect(q7Result);
        } else {
            displayResultIncorrect("Q7");
        }

        //check answer to Question 8
        if (q8CorrectAnswer.isChecked()) {
            quiz_score += 1;
            displayResultCorrect(q8Result);
        } else {
            displayResultIncorrect("Q8");
        }

        score_calculated = 1;
        highlightCorrectAnswers();
        displayScore(quiz_score);
    }

    /**
     * This method will display a message in green text to indicate
     * that a question has been answered correctly.
     *
     * @param qResult TextView associated with the question that was answered
     *                correctly
     */
    public void displayResultCorrect(TextView qResult) {
        String correct = getResources().getString(R.string.result_correct_text);

        qResult.setText(correct);
        //ContextCompat class used here to be compatible with minSDKversion, API 15
        qResult.setTextColor(ContextCompat.getColor(this, R.color.correctColor));
        qResult.setVisibility(View.VISIBLE);

    }

    /**
     * This method will display a message highlighted in red to indicate that
     * the specified question number has been answered incorrectly. In cases
     * where data entry is requested, the correct answer will also be provided.
     *
     * @param questionNum String referring to the question number passed in
     *                    the form, "Qx" where x is an integer 1-12.
     */
    public void displayResultIncorrect(String questionNum) {
        String incorrect = getResources().getString(R.string.result_incorrect_text);
        //Initialize the TextView
        TextView t = new TextView(this);

        switch (questionNum) {
            case "Q1":
                t = q1Result;
                break;
            case "Q2":
                t = q2Result;
                break;
            case "Q3":
                t = q3Result;
                break;
            case "Q4":
                t = q4Result;
                break;
            case "Q5":
                t = q5Result;
                incorrect += "\n" + getResources().getString(R.string.correct_answer_text) +
                        " " + getResources().getString(R.string.f01_answer);
                break;
            case "Q6":
                t = q6Result;
                break;
            case "Q7":
                t = q7Result;
                break;
            case "Q8":
                t = q8Result;
                break;
        }

        t.setText(incorrect);
        t.setTextColor(ContextCompat.getColor(this, R.color.incorrectColor));
        t.setVisibility(View.VISIBLE);

    }

    /**
     * This method will highlight the correct answers for the
     * single and multiple-choice questions.
     */
    public void highlightCorrectAnswers() {
        q1CorrectAnswer.setBackgroundResource(R.color.correctColor);
        q2CB1.setBackgroundResource(R.color.correctColor);
        q2CB2.setBackgroundResource(R.color.correctColor);
        q2CB3.setBackgroundResource(R.color.correctColor);
        q2CB4.setBackgroundResource(R.color.correctColor);
        q3CorrectAnswer.setBackgroundResource(R.color.correctColor);
        q4CorrectAnswer.setBackgroundResource(R.color.correctColor);
        q6CorrectAnswer.setBackgroundResource(R.color.correctColor);
        q7CB2.setBackgroundResource(R.color.correctColor);
        q7CB3.setBackgroundResource(R.color.correctColor);
        q7CB4.setBackgroundResource(R.color.correctColor);
        q8CorrectAnswer.setBackgroundResource(R.color.correctColor);
    }

    /**
     * This method is called to display the score attained by the user on the
     * quiz once the answers have been verified.
     *
     * @param quizScoreTotal The number of correct answers calculated based on
     */
    public void displayScore(int quizScoreTotal) {
        String quiz_result_msg;

        quiz_result_msg = getString(R.string.result_msg_score) + " "
                + quizScoreTotal + " / " + max_score + ".";

        if (quizScoreTotal == 8) {
            quiz_result_msg += "\n" + getString(R.string.congrats);
        } else if (quizScoreTotal < 8 && quizScoreTotal >= 6) {
            quiz_result_msg += "\n" + getString(R.string.good_job);
        } else {
            quiz_result_msg += "\n" + getString(R.string.try_again);
        }

        //Display result message in a Toast
        Toast.makeText(getApplicationContext(), quiz_result_msg, Toast.LENGTH_LONG).show();

    }


    /**
     * This method is called when the 'Reset' button is clicked to clear all
     * text entered, answers selected, highlighted answers, and quiz results.
     */
    public void resetQuiz(View view) {
        removeHighlighting();
        resetQuizScores();

        //Clear Question 1
        q1RadioGrp.clearCheck();
        q1Result.setText("");
        q1Result.setVisibility(View.GONE);


        //Clear Question 2
        if (q2CB1.isChecked()) {
            q2CB1.toggle();
        }

        if (q2CB2.isChecked()) {
            q2CB2.toggle();
        }

        if (q2CB3.isChecked()) {
            q2CB3.toggle();
        }

        if (q2CB4.isChecked()) {
            q2CB4.toggle();
        }
        q2Result.setText("");
        q2Result.setVisibility(View.GONE);

        //Clear Question 3
        q3RadioGrp.clearCheck();
        q3Result.setText("");
        q3Result.setVisibility(View.GONE);

        //Clear Question 4
        q4RadioGrp.clearCheck();
        q4Result.setText("");
        q4Result.setVisibility(View.GONE);

        //Clear Question 5
        q5Guess.setText("");
        q5Result.setText("");
        q5Result.setVisibility(View.GONE);

        //Clear Question 6
        q6RadioGrp.clearCheck();
        q6Result.setText("");
        q6Result.setVisibility(View.GONE);

        //Clear Question 7
        if (q7CB1.isChecked()) {
            q7CB1.toggle();
        }

        if (q7CB2.isChecked()) {
            q7CB2.toggle();
        }

        if (q7CB3.isChecked()) {
            q7CB3.toggle();
        }

        if (q7CB4.isChecked()) {
            q7CB4.toggle();
        }
        q7Result.setText("");
        q7Result.setVisibility(View.GONE);

        //Clear Question 8
        q8RadioGrp.clearCheck();
        q8Result.setText("");
        q8Result.setVisibility(View.GONE);

    }

    /**
     * Removes highlighting of correct answers to each question that was
     * answered incorrectly. Called when Submit or Reset button is clicked.
     */
    public void removeHighlighting() {
        q1CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q2CB1.setBackgroundColor(Color.TRANSPARENT);
        q2CB2.setBackgroundColor(Color.TRANSPARENT);
        q2CB3.setBackgroundColor(Color.TRANSPARENT);
        q2CB4.setBackgroundColor(Color.TRANSPARENT);
        q3CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q4CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q5Guess.setBackgroundResource(textbox_transparent);
        q6CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
        q7CB2.setBackgroundColor(Color.TRANSPARENT);
        q7CB3.setBackgroundColor(Color.TRANSPARENT);
        q7CB4.setBackgroundColor(Color.TRANSPARENT);
        q8CorrectAnswer.setBackgroundColor(Color.TRANSPARENT);
    }


    /**
     * This method is called when the Submit or Reset button is clicked
     * so the quiz score can be properly calculated.
     */
    public void resetQuizScores() {
        //clear quiz score
        quiz_score = 0;
        //clear score calculated flag
        score_calculated = 0;
    }

}
