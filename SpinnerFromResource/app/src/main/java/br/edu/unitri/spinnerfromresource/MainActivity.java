package br.edu.unitri.spinnerfromresource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSpinner();
    }

    public void initSpinner() {

        Spinner spinner = findViewById(R.id.planets_spinner);

        /*
         * Criamos um ArrayAdapter baseado no string-array definido no arquivo strings.xml
         */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.planets_array, // Identificador da fonte de dados
                android.R.layout.simple_spinner_item // Identificador do layout a ser usado para criar a View
        );

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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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
        });
    }
}