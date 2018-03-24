package br.edu.unitri.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static String TAG = MainActivity.class.getName();

    private Button button;
    private EditText time;
    private TextView finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.in_time);
        button = findViewById(R.id.btn_run);
        finalResult = findViewById(R.id.tv_result);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /*
                 * Iniciamos a task no clique do botão
                 */

                Log.d(TAG, "Iniciando AsyncTaskRunner");

                AsyncTaskRunner runner = new AsyncTaskRunner();
                String sleepTime = time.getText().toString();
                runner.execute(sleepTime);
            }
        });
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {

            Log.d(TAG, "Executando doInBackground");

            try {
                int time = Integer.parseInt(params[0])*1000;

                Thread.sleep(time);
                resp = "Tempo de esperada da aplicação " + params[0] + " segundos";

            } catch (InterruptedException e) {

                e.printStackTrace();
                resp = e.getMessage();

            } catch (Exception e) {

                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }

/*
         * Chamado depois que o processo é finalizado
         */

        @Override
        protected void onPostExecute(String result) {

            Log.d(TAG, "Executando onPostExecute");

            progressDialog.dismiss();
            finalResult.setText(result);
        }

        /*
         * Chamado antes do processo iniciar
         */

        @Override
        protected void onPreExecute() {

            Log.d(TAG, "Executando onPreExecute");

            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Por favor, aguarde...",
                    "Esperando por "+time.getText().toString()+ " segundos");
        }



        @Override
        protected void onProgressUpdate(String... text) {

            Log.d(TAG, "Executando onProgressUpdate");

            finalResult.setText(text[0]);

        }
    }
}
