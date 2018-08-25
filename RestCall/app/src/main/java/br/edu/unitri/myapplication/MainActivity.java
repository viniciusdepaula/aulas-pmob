package br.edu.unitri.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //URL of the request we are sending
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
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d(TAG, "API Response: " + response);

//Success Callback

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

//Failure Callback

                    }
                });

// Adding the request to the queue along with a unique string tag
        //MyApplication.getInstance().addToRequestQueue(jsonObjectReq,"getRequest");
        queue.add(jsonObjReq);

    }
}
