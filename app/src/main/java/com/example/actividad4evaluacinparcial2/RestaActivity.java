package com.example.actividad4evaluacinparcial2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RestaActivity extends AppCompatActivity {

    private ListView listViewResults;
    private Button btnRegresar;
    private ArrayAdapter<String> adapter; // Adaptador para la ListView
    private ArrayList<String> results;    // Lista de resultados recibida

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resta);

        listViewResults = findViewById(R.id.listViewResults);
        btnRegresar = findViewById(R.id.btnRegresar);

        results = getIntent().getStringArrayListExtra("results"); // Recibir los resultados

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results);
        listViewResults.setAdapter(adapter);

        btnRegresar.setOnClickListener(v -> finish());
    }
}
