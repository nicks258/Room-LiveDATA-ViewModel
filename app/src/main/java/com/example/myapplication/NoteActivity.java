package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {
    EditText note_et;
    Button saveNote;
    public static final String NOTE_DATA = "note_keyword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        note_et = findViewById(R.id.note_id);
        saveNote = findViewById(R.id.save_et);
        saveNote.setOnClickListener(new View.OnClickListener() {
            Intent resultIntent = new Intent();
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(note_et.getText())){
                    setResult(RESULT_CANCELED, resultIntent);
                }
                else {
                    String note = note_et.getText().toString();
                    resultIntent.putExtra(NOTE_DATA,note);
                    setResult(RESULT_OK,resultIntent);
                }
                finish();
            }
        });


    }
}
