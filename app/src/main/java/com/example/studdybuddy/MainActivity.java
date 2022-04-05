package com.example.studdybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        Button more = findViewById(R.id.button5);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

        ImageButton music =findViewById(R.id.imageButton4);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent h = new Intent(MainActivity.this, music.class);
                startActivity(h);
            }
        });


        ImageButton dictionary =findViewById(R.id.imageButton2);
        dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent s = new Intent(MainActivity.this, Dictionary.class);
                startActivity(s);
            }
        });

        ImageButton notes =findViewById(R.id.imageButton3);
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent m = new Intent(MainActivity.this, note.class);
                startActivity(m);
            }
        });


        ImageButton timer =findViewById(R.id.imageButton);
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent p = new Intent(MainActivity.this, timer.class);
                startActivity(p);
            }
        });



    }
}