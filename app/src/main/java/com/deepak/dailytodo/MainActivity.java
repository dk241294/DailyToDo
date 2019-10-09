package com.deepak.dailytodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import com.deepak.dailytodo.adapter.NotesRecyclerAdapter;
import com.deepak.dailytodo.models.Note;
import com.deepak.dailytodo.util.VerticalSpacingItemDecorator;


public class MainActivity extends AppCompatActivity  implements NotesRecyclerAdapter.OnNoteListener {
    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private ArrayList<Note> mNotes = new ArrayList<Note>();
    private NotesRecyclerAdapter mNoteRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);


        initRecyclerView();
        insertFakeNotes();
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // toolbar.setTitle("Note");
        setTitle("Note");
    }

    private void insertFakeNotes() {
        for (int i = 0; i < 100; i++) {
            Note note = new Note();
            note.setTitle("title #" + i);
            note.setContent("content #: " + i);
            note.setTimestamp("oct 2019");
            mNotes.add(note);
        }
        mNoteRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mNoteRecyclerAdapter = new NotesRecyclerAdapter(mNotes,this);
        VerticalSpacingItemDecorator verticalSpacingItemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(verticalSpacingItemDecorator);
        mRecyclerView.setAdapter(mNoteRecyclerAdapter);
    }


    @Override
    public void onNoteClick(int position) {
       // Intent intent=new Intent(getApplicationContext(),)
        Log.d(TAG, "onNoteClick: "+position);

    }
}