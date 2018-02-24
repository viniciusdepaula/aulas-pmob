package br.edu.unitri.dialintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Exemplo de chamada ao discador padrão do Android
 *
 * @author viniciusdepaula
 */

public class MainActivity extends AppCompatActivity {

    static String TAG = MainActivity.class.getName();

    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.btnMakeCall);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                callDialer();
            }
        });
    }

    /**
     * Faz a chamada ao intent responsável pelo discador
     *
     */

    private void callDialer() {

        EditText phoneNumber = findViewById(R.id.edtPhoneNumber);

        if(TextUtils.isEmpty(phoneNumber.getText().toString())) {

            Toast.makeText(
                    getApplicationContext(),
                    "Informe o número a ser discado!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Uri number = Uri.parse("tel:" + phoneNumber.getText().toString());
        Intent dialerIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(dialerIntent);
    }
}