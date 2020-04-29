package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class NoteViewHolder extends RecyclerView.ViewHolder {
    public TextView noteItemView;
    private int mPosition;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        noteItemView = itemView.findViewById(R.id.txvNote);
    }

    public void setData(String note, int position) {
        noteItemView.setText(note);
        mPosition = position;
    }
}
