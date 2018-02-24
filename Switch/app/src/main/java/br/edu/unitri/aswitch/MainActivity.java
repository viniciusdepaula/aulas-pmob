package br.edu.unitri.aswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckSwitchState(View view) {

        boolean checked = ((Switch) view).isChecked();

        if (checked) {

            Toast.makeText(
                    getApplicationContext(),
                    "Notificações por e-mail ativadas com sucesso",
                    Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(
                    getApplicationContext(),
                    "Notificações por e-mail desativadas com sucesso",
                    Toast.LENGTH_SHORT).show();
        }
    }
}