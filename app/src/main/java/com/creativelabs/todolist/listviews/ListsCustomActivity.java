package com.creativelabs.todolist.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.creativelabs.todolist.R;
import com.creativelabs.todolist.adapters.CustomTodoListAdapter;
import com.creativelabs.todolist.classes.ToDoItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListsCustomActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_lists_custom);

        // 3. Call and assign xml view to locally created list view
        listViewItems = findViewById(R.id.lvItems);
        CustomTodoListAdapter adapter = new CustomTodoListAdapter(this, toDoItems);
        buildActivities();

        // 4. Bind adapter to the list view
        listViewItems.setAdapter(adapter);
    }


    private void buildActivities () {
        // 1. TodoItem object
        for (String item : listItems) {
            toDoItems.add(new ToDoItem(item, "Test description", new Date()));
        }
    }
}