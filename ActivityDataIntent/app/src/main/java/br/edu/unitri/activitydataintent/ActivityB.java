package br.edu.unitri.activitydataintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    static String TAG = ActivityA.class.getName();

    /** Chamado quando a activity é iniciada pela primeira vez */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d(TAG, "The onCreate() event");

        Intent intent = getIntent();
        String message = intent.getStringExtra(ActivityA.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.tvMessage);
        textView.setText(message);
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
        intent.putExtra("EXTRA_MESSAGE", message);
        startActivity(intent);
    }
}
