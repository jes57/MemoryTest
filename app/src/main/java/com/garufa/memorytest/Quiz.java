package com.garufa.memorytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Jason on 11/16/2014.
 */
public class Quiz extends Activity{
    String TAG = "Quiz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        Intent intent_extras = getIntent(), quizIntent = null;

        int quiz_number = intent_extras.getExtras().getInt("quizNumber");

        TextView quiz = (TextView) findViewById(R.id.textView);

        quiz.setText("Open image" + (quiz_number + 1) + ".gif");

        switch (quiz_number){
            case 0: quizIntent = new Intent(Quiz.this, QuizImage1.class); Log.i(TAG, "Calling QuizImage1"); break;
            case 1: quizIntent = new Intent(Quiz.this, QuizImage2.class); Log.i(TAG, "Calling QuizImage2"); break;
            case 2: quizIntent = new Intent(Quiz.this, QuizImage3.class); Log.i(TAG, "Calling QuizImage3"); break;

        }

        startActivity(quizIntent);
    }
}
