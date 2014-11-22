package com.garufa.memorytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Jason on 11/16/2014.
 */
public class Quiz extends Activity{
    String TAG = "Quiz", answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        Intent intent_extras = getIntent(), quizIntent = null;

        int quiz_number = intent_extras.getExtras().getInt("quizNumber");

        TextView quiz = (TextView) findViewById(R.id.textView_quiz_question);
        Button submit_butt = (Button) findViewById(R.id.button_submit);
        RadioButton  radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton  radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton  radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton  radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

        switch (quiz_number){
            case 0: quizIntent = new Intent(Quiz.this, QuizImage1.class); Log.i(TAG, "Calling QuizImage1"); break;
            case 1: quizIntent = new Intent(Quiz.this, QuizImage2.class); Log.i(TAG, "Calling QuizImage2"); break;
            case 2: quizIntent = new Intent(Quiz.this, QuizImage3.class); Log.i(TAG, "Calling QuizImage3"); break;

        }



        startActivity(quizIntent);
    }
}
