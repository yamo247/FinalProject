package com.example.studdybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Dictionary extends AppCompatActivity {

    TextView enlink;
    TextView arlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dictionary);

        enlink = findViewById(R.id.endic);
        arlink = findViewById(R.id.ardic);
        enlink.setMovementMethod(LinkMovementMethod.getInstance());
        arlink.setMovementMethod(LinkMovementMethod.getInstance());
    }
}