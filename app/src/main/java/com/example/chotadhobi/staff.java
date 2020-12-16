package com.example.chotadhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class staff extends AppCompatActivity {
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        Button button_A = (Button) findViewById(R.id.button7);
        final EditText editText_name = (EditText) findViewById(R.id.editTextStaff1);
        final EditText editText_passcode = (EditText) findViewById(R.id.editTextPassword1);
        final TextView textView = (TextView) findViewById(R.id.textView7);
        button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editText_name.getText().toString()).equals("staff")) {
                    i++;
                } else {
                    textView.setText("Entered user name is wrong");
                    i = 0;
                }
                if (i == 1) {
                    if ((editText_passcode.getText().toString()).equals("chota_dhobi")) {
                        i = 0;
                        editText_name.setText("");
                        editText_passcode.setText("");

                        InputMethodManager imm = (InputMethodManager)
                                getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editText_passcode.getWindowToken(), 0);
                        Intent intent_b= new Intent(getApplicationContext(), staff_display.class);
                        startActivity(intent_b);
                    } else {
                        textView.setText("Entered Password is wrong");
                    }
                }
            }
        });
    }
}