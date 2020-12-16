package com.example.chotadhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class student_give extends AppCompatActivity {
    EditText reg;
    EditText quantity;
    Button button;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_give);
        reg=(EditText)findViewById(R.id.editTextTextPersonName3);
        quantity=(EditText)findViewById(R.id.editTextTextPersonName4);
        button=(Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String stu_reg=reg.getText().toString();
                String stu_quantity=quantity.getText().toString();
                //String time = spinner.getSelectedItem().toString();
                if(stu_reg.trim().length()>0 && stu_quantity.trim().length()>0)
                {
                    studentClothesHelper db=new studentClothesHelper(getApplicationContext());
                    db.insertStudentClothes(stu_reg,stu_quantity);
                    quantity.setText("");
                    reg.setText("");

                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(quantity.getWindowToken(), 0);
                    Toast.makeText(getApplicationContext()," Your Clothes are Successfully given",Toast.LENGTH_LONG).show();
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