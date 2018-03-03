package com.example.icondor.androiddemosimplebasicactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String KEY="keyQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // ionel. notice this is where I set what is the main activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //ionel, spinner action
        Spinner sQuestion = (Spinner) findViewById(R.id.spinner_name);

        //comes from db
        List<String> l = SingleListPersons.getInstance().getListOfNames();
        // adapter
        ArrayAdapter<String> al = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, l);

        // attach
        al.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sQuestion.setAdapter(al);
        String valueSelected = readSelected();
        TextView textValue = findViewById(R.id.question); //
        textValue.setText(valueSelected);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // ionel, my code here
                TextView textValue = findViewById(R.id.name_label); // the name I gave in the content_main
                String stringValue = textValue.getText().toString();
                int origValue=Integer.parseInt(stringValue);
                int newValue = BusinessClass.doubleNumber(origValue);
                // textValue.setText(newValue); // funny, this will not work because this is another method
                textValue.setText(Integer.toString(newValue)); // this will not work

                Snackbar.make(view, "I am changing "+origValue+" with "+newValue, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();




                Intent intent = new Intent(MainActivity.this,AnotherActivity.class);
                TextView tv = findViewById(R.id.question); //
                SingleListPersons.getInstance().addInTheListOfNames(tv.getText().toString());
                intent.putExtra(MainActivity.KEY, tv.getText().toString());
                startActivity(intent);



            }
        });
    }

    private String readSelected() {
        Intent i = getIntent();
        String value = i.getStringExtra(MainActivity.KEY);
        return value;

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
