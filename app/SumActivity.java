package com.example.actividad4evaluacinparcial2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SumActivity extends AppCompatActivity {
    private ListView listViewResults;
    private List<String> resultsList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        listViewResults = findViewById(R.id.listViewResults);
        resultsList = new ArrayList<>();

        String operationType = getIntent().getStringExtra("operationType");
        double result = getIntent().getDoubleExtra("result", 0);
        resultsList.add(operationType + " result: " + result);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultsList);
        listViewResults.setAdapter(adapter);
    }
}
