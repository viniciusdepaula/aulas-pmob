package br.edu.unitri.callintent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Exemplo de chamada telefônica no Android
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

                EditText number = findViewById(R.id.edtPhoneNumber);
                phoneNumber = number.getText().toString();

                checkPermissionToCall();
            }
        });
    }

    /**
     * Verifica se a permissão CALL_PHONE foi concedida pelo usuário
     *
     * @return {true} Se a permissão está concedida, {false} caso contrário.
     */

    public boolean checkPermissionToCall() {

        /**
         * Inicialmente, verificamos se a versão do Android é a Marshmallow (Android 6) ou superior
         */

        if (Build.VERSION.SDK_INT >= 23) {

            /*
             * O método requestPermissions verifica se a permissão em questão foi concedita ou não pelo usuário
             */

            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

                makeCall();

                Log.d(TAG, "Permission is granted");
                return true;

            } else {

                Log.d(TAG, "Permission is revoked");

                /**
                 * O método requestPermissions requisita ao usuário a permissão a ser concedida para a aplicação e recebe os seguinte parâmetros:
                 *  A activity que responsável por solicitar a permissão
                 *  A permissão a ser concedida
                 *  Um código de request setado pela aplicação que será utilizado pelo callback onRequestPermissionsResult()
                 */

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }

        /**
         * Esta permissão é automaticamente concedida para as versões inferiores à Marshmallow
         */

        else {
            Log.d("TAG", "Permission is granted");
            return true;
        }
    }


    /**
     * O método onRequestPermissionsResult é chamado indepentente do usuário conceder ou não a permissão
     *
     * @param requestCode é o código do request passado no método requestPermissions(android.app.Activity, String[], int)
     */

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {

            case 1: {

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

                    makeCall();

                } else {

                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void makeCall() {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

            startActivity(callIntent);
        }

    }
}