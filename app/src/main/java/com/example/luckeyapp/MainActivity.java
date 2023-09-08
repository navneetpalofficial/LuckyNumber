package com.example.luckeyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = findViewById(R.id.et);
        TextView textView = findViewById(R.id.textView);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Explicit Intent
              String username =  et.getText().toString();
              Intent i = new Intent(getApplicationContext(), MainActivity2.class);

              // passing the name to second activity
                i.putExtra("name",username); //Key,Value
                startActivity(i);
            }
        });
    }
}