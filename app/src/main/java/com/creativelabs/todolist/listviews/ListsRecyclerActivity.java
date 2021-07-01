package com.creativelabs.todolist.listviews;
import com.creativelabs.todolist.R;
import com.creativelabs.todolist.adapters.RecyclerTodoListAdapter;
import com.creativelabs.todolist.classes.ToDoItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListsRecyclerActivity extends AppCompatActivity {

    //1. creating an empty array list
    private List<ToDoItem> items = new ArrayList<>();
    //2. create adapter
    private RecyclerTodoListAdapter adapter;
    //3. create recycler view
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists_recycler);

        recyclerView = findViewById(R.id.rvList);
        adapter = new RecyclerTodoListAdapter(items);

        // Set layout manager to recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // set adapter to recycler view
        recyclerView.setAdapter(adapter);
        for (int i =0; i<20; i++){
            items.add(new ToDoItem("Item" + i, "Description" + i, new Date()));
        }

        adapter.setToDoItemList(items);
        adapter.notifyDataSetChanged();

    }
}