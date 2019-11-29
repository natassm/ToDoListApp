package com.example.nata_todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewNotesActivity extends AppCompatActivity {

    TextView titleTV, descTV, dateTV;
    EditText titledoes, descdoes, datedoes;
    Button saveTask, cancelTask;

    DatabaseReference reference;
    Integer doesNum = new Random().nextInt();
    String keydoes = Integer.toString(doesNum);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);

        saveTask = findViewById(R.id.newSaveButton);
        cancelTask = findViewById(R.id.newCancelButton);
        titleTV = findViewById(R.id.newTitleDoesTextView);
        descTV = findViewById(R.id.newDescDoesTextView);
        dateTV = findViewById(R.id.newDateDoesTextView);
        titledoes = findViewById(R.id.newTitleDoesEditText);
        descdoes = findViewById(R.id.newDescDoesEditText);
        datedoes = findViewById(R.id.newDateDoesEditText);

        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference().
                        child("DoesApp").child("Does" + doesNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("titledoes").setValue(titledoes.getText().toString());
                        dataSnapshot.getRef().child("descdoes").setValue(descdoes.getText().toString());
                        dataSnapshot.getRef().child("datedoes").setValue(datedoes.getText().toString());
                        dataSnapshot.getRef().child("keydoes").setValue(keydoes);

                        Intent a = new Intent(NewNotesActivity.this, DashboardActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        cancelTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(NewNotesActivity.this, DashboardActivity.class);
                startActivity(a);
            }
        });
    }
}
