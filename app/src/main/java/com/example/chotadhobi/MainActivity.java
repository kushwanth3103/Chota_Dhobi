package com.example.chotadhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public String admin;
    public String passcode_admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin="admin";
        passcode_admin="chota_dhobi";
        Button button_A=(Button)findViewById(R.id.admin);
        Button button_B=(Button)findViewById(R.id.staff);
        Button button_C=(Button)findViewById(R.id.student);
        button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_a=new Intent(getApplicationContext(),admin_pass.class);
                startActivity(intent_a);
            }
        });
        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_c=new Intent(getApplicationContext(),student.class);
                startActivity(intent_c);
            }
        });
        button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_b=new Intent(getApplicationContext(),staff.class);
                startActivity(intent_b);
            }
        });
    }
}