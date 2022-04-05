package com.example.studdybuddy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class note extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<doc> docArrayList;
    MyAdapter myAdapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_note);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        docArrayList = new ArrayList<doc>();
        myAdapter = new MyAdapter(note.this,docArrayList);

        recyclerView.setAdapter(myAdapter);

        EventChangeListener();



        Button newnote = findViewById(R.id.addnewnotebtn);
        newnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent b = new Intent(note.this, addnote.class);
                startActivity(b);
            }
        });


    }

    private void EventChangeListener() {

        db.collection("note").orderBy("title", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null){

                            if (progressDialog.isShowing())
                                progressDialog.dismiss();

                            Log.e("firestore error", error.getMessage());
                            return;
                        }

                        for (DocumentChange documentChange : value.getDocumentChanges()){

                            if (documentChange.getType() == DocumentChange.Type.ADDED){

                                docArrayList.add(documentChange.getDocument().toObject(doc.class));
                            }

                            myAdapter.notifyDataSetChanged();

                            if (progressDialog.isShowing())
                                progressDialog.dismiss();


                        }


                    }
                });


    }
}