package com.example.chotadhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class student extends AppCompatActivity {
    List<String> list;
    List<String> list2;
    EditText reg;
    EditText pass;
    Button button;
    TextView textView;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        reg=(EditText)findViewById(R.id.editTextTextPersonName2);
        pass=(EditText)findViewById(R.id.editTextTextPassword2);
        button=(Button)findViewById(R.id.button2);
        textView=(TextView)findViewById(R.id.textView2);
        studentHelper db=new studentHelper(getApplicationContext());
        list=db.getAllStudents();
        list2=db.getAllStudentsPass();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(String a:list) {
                    if (reg.getText().toString().equals(a)) {
                        i++;
                        break;
                    } else {
                        textView.setText("Entered user name is wrong");
                        i = 0;
                        break;
                    }
                }
                    if (i == 1) {
                        for(String s:list2)
                        {
                            if((pass.getText().toString()).equals(s)) {
                                i = 0;
                                pass.setText("");
                                pass.setText("");

                                InputMethodManager imm = (InputMethodManager)
                                        getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(pass.getWindowToken(), 0);
                                Intent intent_a = new Intent(getApplicationContext(), student_give.class);
                                startActivity(intent_a);
                                break;
                            }
                            else {
                                    textView.setText("Entered Password is wrong");
                                    i=0;
                                    break;
                            }
                        }
                    }
                }
        });

    }
}