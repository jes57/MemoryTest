package com.garufa.memorytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/**
 * Created by Jason on 11/16/2014.
 */
public class QuizImage2 extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 10000; // 10 Seconds
    private int quiz_number;
    String TAG = "QuizImage2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_image2_layout);

        Log.i(TAG, "Inside QuizImage");

        Intent intent_extras = getIntent();
        final Intent quizIntent = new Intent(QuizImage2.this, Quiz.class);

        quiz_number = intent_extras.getExtras().getInt("quizNumber");

        quizIntent.putExtra("quizNumber", quiz_number);
        // Keep this open until the time has expired and return to the quiz
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(quizIntent);
                QuizImage2.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
