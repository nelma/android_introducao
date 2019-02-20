package com.example.formuser;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BasicActivity extends AppCompatActivity {

    static final int REQUEST_CODE = 1;

    private TextView txtViewName;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String name = data.getStringExtra("NOME");
        String lastName = data.getStringExtra("SOBRENOME");
        String email = data.getStringExtra("EMAIL");
        String password = data.getStringExtra("SENHA");
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();

        txtViewName = findViewById(R.id.textViewName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BasicActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
