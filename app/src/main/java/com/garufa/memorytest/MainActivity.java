package com.garufa.memorytest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the array for the listView
        Resources res = getResources();
        String[] memoryTestArray = res.getStringArray(R.array.listView_array);

        // Assign the array to the listView
        final ListAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, memoryTestArray);

        // Set the ListView
        ListView memoryTestListView = (ListView) findViewById(R.id.quizListView);
        memoryTestListView.setAdapter(adapter);

        // Set the onClick event
        memoryTestListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Ready to begin?");
                builder.setIcon(R.drawable.ic_launcher);
                builder.setMessage("You will be presented with an image and given 10 " +
                        "seconds to memorize the images. You will then be presented with a " +
                        "quiz to test your memory.\n\nPress OK to begin or cancel to choose another quiz.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent quizIntent = new Intent(MainActivity.this, Quiz.class);

                        quizIntent.putExtra("quizNumber", pos);
                        startActivity(quizIntent);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.exit_the_app) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
