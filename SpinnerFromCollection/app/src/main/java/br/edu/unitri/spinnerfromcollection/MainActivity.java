package br.edu.unitri.spinnerfromcollection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSpinner();
    }

    public void initSpinner() {

        Spinner spinner = findViewById(R.id.planets_spinner);

        spinner.setOnItemSelectedListener(this);

        List<String> planets = new ArrayList<String>();
        planets.add("Mercúrio");
        planets.add("Vênus");
        planets.add("Marte");
        planets.add("Júpiter");
        planets.add("Saturno");
        planets.add("Urânio");
        planets.add("Urânio");
        planets.add("Nêtuno");


        /*
         * Setamos o Adapter definindo um layout para exibição e a lista de itens
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                planets);

        /*
         * Define o layout do recurso a ser usado para criar a View do combo
         */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /*
         * Setamos o adapter criado no Spinner
         */
        spinner.setAdapter(adapter);


        /*
         * O método setOnItemSelectedListener implementa um listerner quando alguma opção do
         * Spinner é selecionada
         */

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String selectedItemText = (String) parent.getItemAtPosition(position);

        Toast.makeText(
                getApplicationContext(),
                "Opção selecionada: " + selectedItemText,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}