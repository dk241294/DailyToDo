package com.deepak.dailytodo.async;

import android.os.AsyncTask;

import com.deepak.dailytodo.models.Note;
import com.deepak.dailytodo.persistence.NoteDao;

public class InsertAsyncTask extends AsyncTask<Note, Void, Void> {
    private NoteDao mNoteDao;

    public InsertAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.insertNotes(notes);
        return null;

    }
}
