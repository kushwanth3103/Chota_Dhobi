package com.example.chotadhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Button button_add = (Button) findViewById(R.id.button_add);
        Button button_del = (Button) findViewById(R.id.button_delete);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_add = new Intent(admin.this, admin_add.class);
                startActivity(intent_add);
            }
        });
        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_del = new Intent(admin.this, admin_delete.class);
                startActivity(intent_del);
            }
        });
    }
}