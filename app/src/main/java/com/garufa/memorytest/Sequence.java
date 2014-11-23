package com.garufa.memorytest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by Jason on 11/23/2014.
 */
public class Sequence extends Activity {
    String TAG = "Quiz";
    private int rand, intAnswer, quiz_number;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    String[] image1_array, image2_array, image3_array;
    Button submit_butt;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sequence_layout);


        submit_butt = (Button) findViewById(R.id.button_sequence);
        radioButton1 = (RadioButton) findViewById(R.id.rB_seq1);
        radioButton2 = (RadioButton) findViewById(R.id.rB_seq2);
        radioButton3 = (RadioButton) findViewById(R.id.rB_seq3);

        // Set up the dialog for when the user chooses and answer
        builder = new AlertDialog.Builder(Sequence.this);
        builder.setTitle("Quiz Results");
        builder.setIcon(R.drawable.ic_launcher);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        submit_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog;
                if (radioButton2.isChecked()){
                    builder.setMessage("That is correct!\n\nThe correct answer is found " +
                            "by shifting the digits.");
                } else {
                    builder.setMessage("Wrong!\n\nThe correct answer is found " +
                            "by shifting the digits.");
                }
                alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
