package com.example.studdybuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class addnote extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_addnote);


        EditText titleinput = findViewById(R.id.edit_text_title);
        EditText descriptionInput = findViewById(R.id.edit_text_description);
        Button saveBtn = findViewById(R.id.savebtn);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleinput.getText().toString();
                String description = descriptionInput.getText().toString();

                DocumentReference documentReference=firebaseFirestore.collection("note").document();
                Map<String ,Object> note = new HashMap<>();
                note.put("title", title);
                note.put("description", description);

                documentReference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(), "Note Created successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(addnote.this, note.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Failed to create note",Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(addnote.this, notes.class));
                    }
                });
            }
        });

        firebaseFirestore=FirebaseFirestore.getInstance();
    }

    public void saveNote(View view) {
    }
}