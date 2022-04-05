package com.example.studdybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);



        Button more = findViewById(R.id.button8);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent(MainActivity2.this, studyguides.class);
                startActivity(i);
            }
        });

        Button calculator = findViewById(R.id.button9);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent k = new Intent(MainActivity2.this, gradecalculator.class);
                startActivity(k);
            }
        });

        Button games = findViewById(R.id.button10);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent e = new Intent(MainActivity2.this, games.class);
                startActivity(e);
            }
        });


    }
}