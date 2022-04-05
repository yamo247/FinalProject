package com.example.studdybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class gradecalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_gradecalculator);

        EditText num1 = findViewById(R.id.Number1);
        EditText num2 = findViewById(R.id.Number2);
        EditText num3 = findViewById(R.id.Number3);
        EditText num4 = findViewById(R.id.Number4);

        Button calculate = findViewById(R.id.Calculate);
        TextView Result = findViewById(R.id.Total);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Number1 = Integer.parseInt(num1.getText().toString());
                int Number2 = Integer.parseInt(num2.getText().toString());
                int Number3 = Integer.parseInt(num3.getText().toString());
                int Number4 = Integer.parseInt(num4.getText().toString());
                int Total = (Number1 + Number2 + Number3 + Number4)/4;
                Result.setText(Total + "");
            }
        });
    }
}