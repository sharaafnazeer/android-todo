package com.creativelabs.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.creativelabs.todolist.listviews.ListsCustomActivity;
import com.creativelabs.todolist.listviews.ListsSimpleActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView tvNewUser;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvNewUser = findViewById(R.id.tvRegisterView);
        btnLogin = findViewById(R.id.btnLogin);

        tvNewUser.setOnClickListener(v -> {
            Intent registerIntent = new Intent(this, RegisterActivity.class);
            startActivity(registerIntent);
        });

        btnLogin.setOnClickListener(v -> {
            Intent mainIntent = new Intent(this, ListsCustomActivity.class);
            startActivity(mainIntent);
            finish(); // To finish current activity
        });
    }
}