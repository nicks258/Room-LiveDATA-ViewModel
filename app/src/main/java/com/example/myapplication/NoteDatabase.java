package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.lang.invoke.VolatileCallSite;

@Database(entities = Note.class, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

     abstract NoteDao noteDao();

    private static volatile NoteDatabase noteDatabaseIntance;

    static NoteDatabase getNoteDatabaseInstance(final Context context){
        if (noteDatabaseIntance == null){
            noteDatabaseIntance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,"note_database")
                    .build();
        }
        return noteDatabaseIntance;
    }
}
