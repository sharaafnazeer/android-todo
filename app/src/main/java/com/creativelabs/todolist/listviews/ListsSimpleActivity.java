package com.creativelabs.todolist.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.creativelabs.todolist.R;
import com.creativelabs.todolist.classes.ToDoItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 1. Arrays - fixed size
// 2. ArrayList / List - dynamic size

public class ListsSimpleActivity extends AppCompatActivity {

    // 1. Creating a list view items
    String [] listItems = { "Meeting with team", "Online lecture", "Playing time", "Washing cloths", "Watching TV",
            "Movie night", "Party time", "Wondering here and there" };

    // 1. Creating a array list of ToDo items
    List<ToDoItem> toDoItems = new ArrayList<ToDoItem>();

    // 2. Initialize an List view locally
    private ListView listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists_simple);

        // 3. Call and assign xml view to locally created list view
        listViewItems = findViewById(R.id.lvItems);

        // Adapter - Something an intermediate communication between list view and list items

        // Parameters -> 1. Context 2. List view template 3. List view array
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);

        // Bind adapter to the list view interface
        listViewItems.setAdapter(adapter);

        // 1. setOnClickListener()
        // 2. setOnItemClickListener()

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currentValue = (String) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), currentValue, Toast.LENGTH_LONG).show();
            }
        });
    }
}