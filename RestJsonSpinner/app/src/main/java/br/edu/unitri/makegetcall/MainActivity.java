package br.edu.unitri.makegetcall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static String TAG = MainActivity.class.getName();

    List<String> listaProdutos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://www.mocky.io/v2/5b8144a63400001000ecb31a";
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

                            JSONObject jsonObject = new JSONObject(response.toString());

                            JSONArray jsonArray = jsonObject.getJSONArray("produtos");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonobject = jsonArray.getJSONObject(i);
                                String nomeProduto = jsonobject.getString("nome");
                                listaProdutos.add(nomeProduto);
                            }

                            popularSpinner(listaProdutos);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                },

                /* Callback chamado em caso de erro */

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e(TAG, "Ocorreu um erro ao consultar a API: " + error);
                    }
                });

        queue.add(jsonObjReq);
    }

    private void popularSpinner(List<String> listaProdutos) {
        Spinner spinner1 = findViewById(R.id.produtos_spinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, listaProdutos );

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);
    }
}