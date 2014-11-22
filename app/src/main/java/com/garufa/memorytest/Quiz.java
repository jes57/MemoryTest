package com.garufa.memorytest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Jason on 11/16/2014.
 */
public class Quiz extends Activity{
    String TAG = "Quiz", answer;
    private int rand, intAnswer, quiz_number;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    String[] image1_array, image2_array, image3_array;
    Button submit_butt;
    AlertDialog.Builder builder;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        Intent intent_extras = getIntent(), quizIntent = null;

        quiz_number = intent_extras.getExtras().getInt("quizNumber");

        TextView quiz = (TextView) findViewById(R.id.textView_quiz_question);
        submit_butt = (Button) findViewById(R.id.button_submit);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

        switch (quiz_number){
            case 0: quizIntent = new Intent(Quiz.this, QuizImage1.class); break;
            case 1: quizIntent = new Intent(Quiz.this, QuizImage2.class); break;
            case 2: quizIntent = new Intent(Quiz.this, QuizImage3.class); break;

        }


        // Set up the dialog for when the user chooses and answer
        builder = new AlertDialog.Builder(Quiz.this);
        builder.setTitle("Quiz Results");
        builder.setIcon(R.drawable.ic_launcher);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });


        // Get the array for the listView
        Resources res = getResources();
        image1_array = res.getStringArray(R.array.image1);
        image2_array = res.getStringArray(R.array.image2);
        image3_array = res.getStringArray(R.array.image3);

        // Set the random variables for the correct answer and the index of the array for the answer
        Random random = new Random();
        rand = random.nextInt(20);
        intAnswer = random.nextInt(4);
        Log.i(TAG, "The answer is " + intAnswer);

        // Set the text of the radio buttons
        setAnswers();

        submit_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog;
                switch (intAnswer){
                    case 1:
                        if (radioButton1.isChecked()){
                            builder.setMessage("That is correct!");
                        } else {
                            builder.setMessage("Sorry that was wrong.");
                        }
                        alertDialog = builder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        if (radioButton2.isChecked()){
                            builder.setMessage("That is correct!");
                        } else {
                            builder.setMessage("Sorry that was wrong.");
                        }
                        alertDialog = builder.create();
                        alertDialog.show();
                        break;
                    case 3:
                        if (radioButton3.isChecked()){
                            builder.setMessage("That is correct!");
                        } else {
                            builder.setMessage("Sorry that was wrong.");
                        }
                        alertDialog = builder.create();
                        alertDialog.show();
                        break;
                    case 4:
                        if (radioButton4.isChecked()){
                            builder.setMessage("That is correct!");
                        } else {
                            builder.setMessage("Sorry that was wrong.");
                        }
                        alertDialog = builder.create();
                        alertDialog.show();
                        break;
                }
            }
        });

        startActivity(quizIntent);
    }

    private void setAnswers() {
        switch (intAnswer){
            case 1:
                Log.i(TAG, "Setting answer to " + intAnswer);
                setAnswers1();
                break;
            case 2:
                Log.i(TAG, "Setting answer to " + intAnswer);
                setAnswers2();
                break;
            case 3:
                Log.i(TAG, "Setting answer to " + intAnswer);
                setAnswers3();
                break;
            case 4:
                Log.i(TAG, "Setting answer to " + intAnswer);
                setAnswers4();
                break;
        }
    }

    private void setAnswers4() {
        switch (quiz_number){
            case 1:
                radioButton1.setText(image3_array[rand]);
                radioButton2.setText(image2_array[rand]);
                radioButton3.setText(image3_array[rand]);
                break;
            case 2:
                radioButton1.setText(image2_array[rand]);
                radioButton2.setText(image1_array[rand]);
                radioButton3.setText(image3_array[rand]);
                break;
            case 3:
                radioButton1.setText(image2_array[rand]);
                radioButton2.setText(image2_array[rand]);
                radioButton3.setText(image1_array[rand]);
                break;
        }
    }

    private void setAnswers3() {
        switch (quiz_number){
            case 1:
                radioButton1.setText(image3_array[rand]);
                radioButton2.setText(image2_array[rand]);
                radioButton3.setText(image1_array[rand]);
                break;
            case 2:
                radioButton1.setText(image3_array[rand]);
                radioButton2.setText(image1_array[rand]);
                radioButton3.setText(image2_array[rand]);
                break;
            case 3:
                radioButton1.setText(image1_array[rand]);
                radioButton2.setText(image2_array[rand]);
                radioButton3.setText(image3_array[rand]);
                break;
        }
    }

    private void setAnswers2() {
        switch (quiz_number){
            case 1:
                radioButton1.setText(image3_array[rand]);
                radioButton2.setText(image1_array[rand]);
                radioButton3.setText(image2_array[rand]);
                break;
            case 2:
                radioButton1.setText(image1_array[rand]);
                radioButton2.setText(image2_array[rand]);
                radioButton3.setText(image3_array[rand]);
                break;
            case 3:
                radioButton1.setText(image2_array[rand]);
                radioButton2.setText(image3_array[rand]);
                radioButton3.setText(image1_array[rand]);
                break;
        }
    }

    private void setAnswers1() {
        switch (quiz_number){
            case 1:
                radioButton1.setText(image1_array[rand]);
                radioButton2.setText(image2_array[rand]);
                radioButton3.setText(image3_array[rand]);
                break;
            case 2:
                radioButton1.setText(image2_array[rand]);
                radioButton2.setText(image1_array[rand]);
                radioButton3.setText(image3_array[rand]);
                break;
            case 3:
                radioButton1.setText(image3_array[rand]);
                radioButton2.setText(image2_array[rand]);
                radioButton3.setText(image1_array[rand]);
                break;
        }
    }
}
