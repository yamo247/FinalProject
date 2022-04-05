package com.example.studdybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class games extends AppCompatActivity {

    TextView gg1;
    TextView gg2;
    TextView gg3;
    TextView gg4;
    TextView gg5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_games);

        gg1 = findViewById(R.id.g1);
        gg2 = findViewById(R.id.g2);
        gg3 = findViewById(R.id.g3);
        gg4 = findViewById(R.id.g4);
        gg5 = findViewById(R.id.g5);

        gg1.setMovementMethod(LinkMovementMethod.getInstance());
        gg2.setMovementMethod(LinkMovementMethod.getInstance());
        gg3.setMovementMethod(LinkMovementMethod.getInstance());
        gg4.setMovementMethod(LinkMovementMethod.getInstance());
        gg5.setMovementMethod(LinkMovementMethod.getInstance());

    }
}