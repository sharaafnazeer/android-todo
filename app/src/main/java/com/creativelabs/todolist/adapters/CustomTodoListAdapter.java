package com.creativelabs.todolist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.creativelabs.todolist.R;
import com.creativelabs.todolist.classes.ToDoItem;

import java.util.ArrayList;
import java.util.List;

public class CustomTodoListAdapter extends ArrayAdapter<ToDoItem> {

    public CustomTodoListAdapter(@NonNull Context context, @NonNull List<ToDoItem> toDoItems) {
        super(context, 0,  toDoItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // 1. Get items position
        ToDoItem item  = getItem(position);
        // 2. Check whether convertView is null
        if (convertView == null) {
            // 3. Inflate our custom view to the current view
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_list_todo, parent, false);
        }

        // 4. Get and initialize text views
        TextView textTodoName = convertView.findViewById(R.id.tvTodoName);
        TextView textTodoDesc = convertView.findViewById(R.id.tvTodoDesc);
        TextView textTodoDate = convertView.findViewById(R.id.tvTodoDate);
        ConstraintLayout layout = convertView.findViewById(R.id.clLayout);

        // 5. Set values to the text views
        textTodoName.setText(item.getName());
        textTodoDesc.setText(item.getDescription());
        textTodoDate.setText(item.getDate().toString());
        layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
