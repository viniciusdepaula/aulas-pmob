package br.edu.unitri.mapintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Exemplo de chamada do discador do Android
 *
 * @author viniciusdepaula
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.btnCallMap);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                callDialer();
            }
        });
    }

    /**
     * Faz a chamada ao intent responsável pelos mapas
     *
     */

    private void callDialer() {

        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        //Uri location = Uri.parse("geo:37.422219,-122.08364?z=14");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }
}
