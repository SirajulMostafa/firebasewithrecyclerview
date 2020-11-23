package com.mostafa.firebasewithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mostafa.firebasewithrecyclerview.Adapters.MainAdapter;
import com.mostafa.firebasewithrecyclerview.Models.Student;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mbase;
    private RecyclerView recyclerView;
    MainAdapter adapter; // Create Object of the Adapter class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a instance of the database and get 
        // its reference 
        mbase = FirebaseDatabase.getInstance().getReference();

        recyclerView = findViewById(R.id.recyclerView);

        // To display the Recycler view linearly 
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Student> options = new FirebaseRecyclerOptions.Builder<Student>()
                .setQuery(mbase.child("student"),Student.class)
                .build();

        // It is a class provide by the FirebaseUI to make a 
        // query in the database to fetch appropriate data 
//
        // Connecting object of required Adapter class to 
        // the Adapter class itself 
        adapter = new MainAdapter(options);
        // Connecting Adapter class with the Recycler view*/ 
        recyclerView.setAdapter(adapter);

    }
    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}