package com.example.nata_todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder> {

    Context context;
    ArrayList<ToDoList> todoList;

    public ToDoListAdapter(Context c, ArrayList<ToDoList> p){
        context = c;
        todoList = p;
    }

    @NonNull
    @Override
    public ToDoListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ToDoListViewHolder(LayoutInflater.from(context).inflate(R.layout.view_holder_item_does, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoListViewHolder toDoListViewHolder, int i) {
        toDoListViewHolder.titledoes.setText(todoList.get(i).getTitledoes());
        toDoListViewHolder.descdoes.setText(todoList.get(i).getDatadoes());
        toDoListViewHolder.datedoes.setText(todoList.get(i).getDatedoes());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    class ToDoListViewHolder extends RecyclerView.ViewHolder {

        TextView titledoes, descdoes, datedoes;

        public ToDoListViewHolder(@NonNull View itemView) {
            super(itemView);

            titledoes = itemView.findViewById(R.id.itemDoesTitleTextView);
            descdoes = itemView.findViewById(R.id.itemDoesDescTextView);
            datedoes = itemView.findViewById(R.id.itemDoesDateTextView);
        }
    }
}
