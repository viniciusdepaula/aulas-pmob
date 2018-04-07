package unitri.edu.br.pushnotifications;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        handleNotification();
    }

    private void handleNotification() {

        String title = "", body = "";

        Bundle bundle = getIntent().getExtras();

        if (getIntent().hasExtra("EXTRA_TITLE")) {

            title = bundle.getString("EXTRA_TITLE");
        }
        if (getIntent().hasExtra("EXTRA_BODY")) {

            body = bundle.getString("EXTRA_BODY");
        }

        if (!title.equals("") || !body.equals("")) {

            showDialog(title, body);
        }
    }

    private void showDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}