package br.edu.unitri.makegetcall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvTemp = findViewById(R.id.weather);

        String url= "http://api.openweathermap.org/data/2.5/weather?q=Uberlandia,br&units=metric&appid=4fa74572c6b3268a6ae5bd1150d7a748";
        RequestQueue queue = Volley.newRequestQueue(this);

        /**
         JsonObjectRequest espera 5 parâmetros
         Request Type - Tipo da requisição: GET,POST
         URL          - URL da API
         JSONObject   - Objeto JSON da requisição (parameters.null se a requisição for do tipo GET)
         Listener     - Implementação de um Response.Listener() com um callback de sucesso e de erro
         **/

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {

                    /* Callback chamado em caso de sucesso */

                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d(TAG, "API Response: " + response);

                        try {

                            JSONObject main = response.getJSONObject("main");
                            String temp = main.getString("temp");

                            tvTemp.setText(temp.replace(".",","));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                /* Callback chamado em caso de erro */

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e(TAG, "Ocorreu um erro ao consultar temperatura " + error);
                    }
                });

        queue.add(jsonObjReq);
    }
}