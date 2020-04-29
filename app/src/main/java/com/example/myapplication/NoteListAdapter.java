package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private final LayoutInflater inflater;
    private Context context;
    private List<Note> mNote;
    public NoteListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.list_item,parent,false);
        NoteViewHolder viewHolder = new NoteViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if(mNote!= null){
            Note note = mNote.get(position);
            holder.setData(note.getNote(),position);
        }
        else {
            holder.noteItemView.setText("No Note Founds");
        }
    }

    void setNotes(List<Note> notes){
        mNote = notes;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (mNote != null){
            return mNote.size();
        }
        else return 0;
    }
}
