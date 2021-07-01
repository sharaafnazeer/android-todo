package com.creativelabs.todolist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.creativelabs.todolist.R;
import com.creativelabs.todolist.classes.ToDoItem;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTodoListAdapter extends RecyclerView.Adapter<RecyclerTodoListAdapter.ViewHolder> {

    private List<ToDoItem> toDoItemList = new ArrayList<>();

    public RecyclerTodoListAdapter(List<ToDoItem> toDoItemList) {
        this.toDoItemList = toDoItemList;
    }

    public void setToDoItemList(List<ToDoItem> toDoItemList) {
        this.toDoItemList = toDoItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_custom_list_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerTodoListAdapter.ViewHolder holder, int position) {

        ToDoItem item = toDoItemList.get(position);
        holder.getTodoName().setText(item.getName());
        holder.getTodoDesc().setText(item.getDescription());
        holder.getTodoDate().setText(item.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return toDoItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView todoName;
        private TextView todoDesc;
        private TextView todoDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            todoName = itemView.findViewById(R.id.tvTodoName);
            todoDesc = itemView.findViewById(R.id.tvTodoDesc);
            todoDate = itemView.findViewById(R.id.tvTodoDate);
        }

        public TextView getTodoName() {
            return todoName;
        }

        public TextView getTodoDesc() {
            return todoDesc;
        }

        public TextView getTodoDate() {
            return todoDate;
        }
    }
}
