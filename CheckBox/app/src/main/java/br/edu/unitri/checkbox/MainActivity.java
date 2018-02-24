package br.edu.unitri.checkbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cbBacon:
                if (checked)
                    Toast.makeText(
                            getApplicationContext(),
                            "Adicional incluído: Bacon",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(
                            getApplicationContext(),
                            "Adicional removido: Bacon",
                            Toast.LENGTH_SHORT).show();

                break;
            case R.id.cbQueijo:
                if (checked)
                    Toast.makeText(
                            getApplicationContext(),
                            "Adicional incluído: Queijo",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(
                            getApplicationContext(),
                            "Adicional removido: Queijo",
                            Toast.LENGTH_SHORT).show();
                break;
            // TODO: Veggie sandwich
        }
    }
}
