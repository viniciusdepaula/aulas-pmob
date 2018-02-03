package br.edu.unitri.activitydataintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityA extends AppCompatActivity {

    static String TAG = ActivityA.class.getName();
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";


    /** Chamado quando a activity é iniciada pela primeira vez */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Log.d(TAG, "The onCreate() event");

        final Button button = findViewById(R.id.btnSendData);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity();
            }
        });
    }

    /** Chamado quando a actitity está prestes a se tornar visível para o usuário */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "The onStart() event");
    }

    /** Chamado quando a activity se tornou efetivamente visível para o usuário */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "The onResume() event");
    }

    /** Chamado quando outra activity ganhará o foco ou está sendo criada */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "The onPause() event");
    }

    /** Chamado quando a activity não está mais visível para o usuário */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "The onStop() event");
    }

    /** Chamado para iniciar uma nova activity */
    public void startActivity() {

        Intent intent = new Intent(this, ActivityB.class);
        EditText editText = (EditText) findViewById(R.id.edtWriteSomething);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}