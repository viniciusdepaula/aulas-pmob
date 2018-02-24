package br.edu.unitri.edittextmask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextWatcher cpfMask, cnpjMask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cpf = (EditText) findViewById(R.id.edtCpf);
        cpfMask = Mask.insert("###.###.###-##", cpf);
        cpf.addTextChangedListener(cpfMask);

        final EditText cnpj = (EditText) findViewById(R.id.edtCnpj);
        cnpjMask = Mask.insert("##.###.###/####-##", cnpj);
        cnpj.addTextChangedListener(cnpjMask);
    }
}
