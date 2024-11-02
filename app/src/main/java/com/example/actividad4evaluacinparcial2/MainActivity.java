package com.example.actividad4evaluacinparcial2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etPrimero, etSegundo;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir;
    private Button btnViewSuma, btnViewResta, btnViewMultiplicacion, btnViewDivision;
    private ArrayList<String> sumaResults = new ArrayList<>();
    private ArrayList<String> restaResults = new ArrayList<>();
    private ArrayList<String> multiplicacionResults = new ArrayList<>();
    private ArrayList<String> divisionResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etPrimero = findViewById(R.id.etPrimero);
        etSegundo = findViewById(R.id.etSegundo);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnViewSuma = findViewById(R.id.btnViewSuma);
        btnViewResta = findViewById(R.id.btnViewResta);
        btnViewMultiplicacion = findViewById(R.id.btnViewMultiplicacion);
        btnViewDivision = findViewById(R.id.btnViewDivision);

        btnSumar.setOnClickListener(v -> realizarOperacion('+'));
        btnRestar.setOnClickListener(v -> realizarOperacion('-'));
        btnMultiplicar.setOnClickListener(v -> realizarOperacion('*'));
        btnDividir.setOnClickListener(v -> realizarOperacion('/'));

        btnViewSuma.setOnClickListener(v -> viewResults('+'));
        btnViewResta.setOnClickListener(v -> viewResults('-'));
        btnViewMultiplicacion.setOnClickListener(v -> viewResults('*'));
        btnViewDivision.setOnClickListener(v -> viewResults('/'));
    }

    private void realizarOperacion(char operacion) {
        if (etPrimero.getText().toString().isEmpty() || etSegundo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(etPrimero.getText().toString());
        double num2 = Double.parseDouble(etSegundo.getText().toString());
        String resultString;

        switch (operacion) {
            case '+':
                resultString = num1 + " + " + num2 + " = " + (num1 + num2);
                sumaResults.add(resultString);
                break;
            case '-':
                resultString = num1 + " - " + num2 + " = " + (num1 - num2);
                restaResults.add(resultString);
                break;
            case '*':
                resultString = num1 + " * " + num2 + " = " + (num1 * num2);
                multiplicacionResults.add(resultString);
                break;
            case '/':
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_LONG).show();
                    return;
                }
                resultString = num1 + " / " + num2 + " = " + (num1 / num2);
                divisionResults.add(resultString);
                break;
        }
        Toast.makeText(this, "Operation successful", Toast.LENGTH_SHORT).show();
    }

    private void viewResults(char operation) {
        Intent intent;
        switch (operation) {
            case '+':
                intent = new Intent(MainActivity.this, SumActivity.class);
                intent.putStringArrayListExtra("results", sumaResults);
                break;
            case '-':
                intent = new Intent(MainActivity.this, RestaActivity.class);
                intent.putStringArrayListExtra("results", restaResults);
                break;
            case '*':
                intent = new Intent(MainActivity.this, MultiplicacionActivity.class);
                intent.putStringArrayListExtra("results", multiplicacionResults);
                break;
            case '/':
                intent = new Intent(MainActivity.this, DivisionActivity.class);
                intent.putStringArrayListExtra("results", divisionResults);
                break;
            default:
                return; // Opcionalmente manejar error
        }
        startActivity(intent);
    }
}
