package com.deepak.dailytodo.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.deepak.dailytodo.models.Note;

import java.util.List;

public class NoteRepository  {
    private NoteDatabase mNoteDatabase; //refrence

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note){

    }

    public void updateNoteTask(Note note){

    }

    public LiveData<List<Note>> retrieveNotesTask() {

        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNoteTask(Note note){

    }
}
