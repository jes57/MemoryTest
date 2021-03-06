package com.garufa.memorytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/**
 * Created by Jason on 11/24/2014.
 */
public class Splash extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 3000; // 3 Seconds
    String TAG = "Splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        Log.i(TAG, "Inside Splash");

        final Intent quizIntent = new Intent(Splash.this, MainActivity.class);

        // Keep this open until the time has expired and return to the quiz
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(quizIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
