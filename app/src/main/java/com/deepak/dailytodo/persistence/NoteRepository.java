package com.deepak.dailytodo.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.deepak.dailytodo.async.DeleteAsyncTask;
import com.deepak.dailytodo.async.InsertAsyncTask;
import com.deepak.dailytodo.async.UpdateAsyncTask;
import com.deepak.dailytodo.models.Note;

import java.util.List;

public class NoteRepository {
    private NoteDatabase mNoteDatabase; //refrence

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note) {
        new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);

    }

    public void updateNoteTask(Note note) {
        new UpdateAsyncTask(mNoteDatabase.getNoteDao()).execute(note);

    }

    public LiveData<List<Note>> retrieveNotesTask() {

        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNoteTask(Note note) {
        new DeleteAsyncTask(mNoteDatabase.getNoteDao()).execute(note);

    }
}
