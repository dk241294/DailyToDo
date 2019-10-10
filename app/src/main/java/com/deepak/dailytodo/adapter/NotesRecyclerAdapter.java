package com.deepak.dailytodo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deepak.dailytodo.R;
import com.deepak.dailytodo.models.Note;
import com.deepak.dailytodo.util.TimeStamp;

import java.util.ArrayList;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder> {
    private static final String TAG = "NotesRecyclerAdapter";
    //to hold notes
    private ArrayList<Note> mNotes = new ArrayList<>();
    private OnNoteListener onNoteListener;

    public NotesRecyclerAdapter(ArrayList<Note> notes,OnNoteListener onNoteListener) {
        this.mNotes = notes;
        this.onNoteListener=onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_list_item, parent, false);
        return new ViewHolder(view,onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try{
            //String date=mNotes.get(position).getTimestamp().substring(1);
            String month = mNotes.get(position).getTimestamp().substring(0, 2);
            month = TimeStamp.getMonthFromNumber(month);
            String year = mNotes.get(position).getTimestamp().substring(3);
            String timestamp = " "+ month + " " + year;
            holder.timeStamp.setText(timestamp);
            holder.title.setText(mNotes.get(position).getTitle());
        }catch (NullPointerException e){
            Log.e(TAG, "onBindViewHolder: Null Pointer: " + e.getMessage() );
        }
    }


    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, timeStamp;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView,OnNoteListener onNoteListener) {
            super(itemView);

            title = itemView.findViewById(R.id.note_title);
            timeStamp = itemView.findViewById(R.id.note_timestamp);
            this.onNoteListener=onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());

        }
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}