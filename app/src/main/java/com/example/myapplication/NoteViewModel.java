package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class NoteViewModel extends AndroidViewModel {
    private NoteDao noteDao;
    private NoteDatabase noteDatabase;
    private LiveData<List<Note>> mAllNotes;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteDatabase = NoteDatabase.getNoteDatabaseInstance(application);
        noteDao = noteDatabase.noteDao();
        mAllNotes = noteDao.getAllNotes();
    }

    public void insert(Note note){
        new InsertAsyncTask(noteDao).execute(note);
    }

    LiveData<List<Note>> getAllNotes(){
        return mAllNotes;
    }

    private class InsertAsyncTask extends AsyncTask<Note,Void,Void> {
        NoteDao noteDao;
        public InsertAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }


    }
}
