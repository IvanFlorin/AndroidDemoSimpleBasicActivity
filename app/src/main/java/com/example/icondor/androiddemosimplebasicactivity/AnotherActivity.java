package com.example.icondor.androiddemosimplebasicactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        display();

        Button b = findViewById(R.id.button_persons);
        b.setOnClickListener(myCreateButtonListener);


    }

    private View.OnClickListener myCreateButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(AnotherActivity.this,MainActivity.class);
            startActivity(intent);
        }
    };



    private void display() {

        final ListView lw = findViewById(R.id.list_persons);

        List<String> myModel = SingleListPersons.getInstance().getListOfNames();



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, myModel); // second param is a built in layout
        lw.setAdapter(adapter);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AnotherActivity.this,MainActivity.class);

                String current = (String)lw.getItemAtPosition(position);
                intent.putExtra(MainActivity.KEY, current);

                startActivity(intent);
            }
        });

    }

}
