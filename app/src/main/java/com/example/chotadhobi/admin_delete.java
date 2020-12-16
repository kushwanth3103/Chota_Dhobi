package com.example.chotadhobi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class admin_delete extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete);
        listView=(ListView)findViewById(R.id.listview);
        loadListView();
    }
    public void loadListView()
    {
        studentHelper db=new studentHelper((getApplicationContext()));
        List<String> regs=db.getAllStudents();

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,regs);
        listView.setAdapter(arrayAdapter);
    }
}