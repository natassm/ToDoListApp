package com.example.nata_todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    FloatingActionButton btnAddNew;

    DatabaseReference reference;
    RecyclerView listTask;
    ArrayList<ToDoList> list;
    ToDoListAdapter tdlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAddNew = findViewById(R.id.dashboardAddButton);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(DashboardActivity.this, NewNotesActivity.class);
                startActivity(a);
            }
        });

        listTask = findViewById(R.id.dashboardListRecyclerView);
        listTask.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<ToDoList>();

        reference = FirebaseDatabase.getInstance().getReference().child("DoesApp");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshotData: dataSnapshot.getChildren())
                {
                    ToDoList tdl = snapshotData.getValue(ToDoList.class);
                    list.add(tdl);
                }
                tdlAdapter = new ToDoListAdapter(DashboardActivity.this, list);
                listTask.setAdapter(tdlAdapter);
                tdlAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
