package br.edu.unitri.opennewactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityB extends AppCompatActivity {

    static String TAG = ActivityB.class.getName();

    /** Chamado quando a activity é iniciada pela primeira vez */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d(TAG, "The onCreate() event");

        final Button button = findViewById(R.id.btnStartActivity);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity();
            }
        });
    }

    /**
     * Chamado quando a actitity está prestes a se tornar visível para o usuário
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "The onStart() event");
    }

    /**
     * Chamado quando a activity se tornou efetivamente visível para o usuário
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "The onResume() event");
    }

    /**
     * Chamado quando outra activity ganhará o foco ou está sendo criada
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "The onPause() event");
    }

    /**
     * Chamado quando a activity não está mais visível para o usuário
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "The onStop() event");
    }

    /**
     * Chamado quando a activity é destruída
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "The onDestroy() event");
    }

    /** Chamado para iniciar uma nova activity */
    public void startActivity() {

        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }
}