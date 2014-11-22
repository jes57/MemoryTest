package com.garufa.memorytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/**
 * Created by Jason on 11/16/2014.
 */
public class QuizImage3 extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 3000; // 3 Seconds
    String TAG = "QuizImage3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_image3_layout);

        Log.i(TAG, "Inside QuizImage");

        // Keep this open until the time has expired and return to the quiz
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                QuizImage3.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
