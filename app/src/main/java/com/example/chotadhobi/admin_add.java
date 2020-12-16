package com.example.chotadhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_add extends AppCompatActivity {
    Button button_add_stu;
    EditText editText_reg;
    EditText editText_mob;
    //delete d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add);
        button_add_stu=findViewById(R.id.button1);
        editText_reg=findViewById(R.id.editText1);
        editText_mob=findViewById(R.id.editTextText2);
        //d=new delete();
        //d.loadListView();
        button_add_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String stu_reg=editText_reg.getText().toString();
                String stu_mob=editText_mob.getText().toString();
                if(stu_reg.trim().length()>0 && stu_mob.trim().length()>0)
                {
                    studentHelper db=new studentHelper(getApplicationContext());
                    db.insertStudent(stu_reg,stu_mob);

                    editText_mob.setText("");
                    editText_reg.setText("");

                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText_mob.getWindowToken(), 0);
                    Toast.makeText(getApplicationContext(),"Successfully Created",Toast.LENGTH_LONG).show();
                    //d.loadListView();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please enter respective details",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}