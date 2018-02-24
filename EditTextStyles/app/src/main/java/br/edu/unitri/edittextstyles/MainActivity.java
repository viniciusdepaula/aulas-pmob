package br.edu.unitri.edittextstyles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextWatcher cpfMask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cpf = (EditText) findViewById(R.id.edtCpf);
        // Armazene seus TextWatcher para posterior uso
        cpfMask = Mask.insert("###.###.###-##", cpf);
        cpf.addTextChangedListener(cpfMask);
    }
}
