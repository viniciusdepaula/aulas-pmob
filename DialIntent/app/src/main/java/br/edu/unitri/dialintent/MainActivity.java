package br.edu.unitri.dialintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        Uri number = Uri.parse("tel:" + phoneNumber.getText().toString());
        Intent dialerIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(dialerIntent);
    }
}