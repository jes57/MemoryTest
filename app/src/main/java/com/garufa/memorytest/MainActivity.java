package com.garufa.memorytest;

import android.app.Activity;
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
                String testPicked = "You selected " +
                        String.valueOf(parent.getItemAtPosition(position));

                Toast.makeText(MainActivity.this, testPicked, Toast.LENGTH_SHORT).show();
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
        }

        return super.onOptionsItemSelected(item);
    }
}
