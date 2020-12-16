package com.example.chotadhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class staff_display extends AppCompatActivity {
    ListView listView7;
    public  String time_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete);
        listView7=(ListView)findViewById(R.id.listview);
        //Spinner spinner=findViewById(R.id.spinner2);
        //time_up=spinner.getSelectedItem().toString();
        loadListView();
    }
    public void loadListView()
    {
        studentClothesHelper db=new studentClothesHelper((getApplicationContext()));
        List<String> regs=db.getAllStudentsClothes();
       /* List<String> timer=db.getTime();
        List<String> array_disp=new ArrayList<>();
        for(String i:timer)
        {
            if(Integer.parseInt(time_up)-Integer.parseInt(i)>=0)
            {
                array_disp.add(regs.get(timer.indexOf(i)));
            }
        }*/
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,regs);
        listView7.setAdapter(arrayAdapter);
    }
}