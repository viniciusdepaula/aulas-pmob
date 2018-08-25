package br.edu.unitri.makegetcall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    static String TAG = MainActivity.class.getName();

    String url = "http://www.mocky.io/";

    List<String> listaProdutos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRetrofitArray();

    }

    void getRetrofitArray() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProdutosAPI service = retrofit.create(ProdutosAPI.class);

        Call<List<Produto>> call = service.getProdutos();

        call.enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(retrofit.Response<List<Produto>> response, Retrofit retrofit) {

                try {

                    List<Produto> produtos = response.body();

                    for (int i = 0; i < produtos.size(); i++) {

                        String nomeProduto = produtos.get(i).getNome();
                        listaProdutos.add(nomeProduto);
                    }

                    popularSpinner(listaProdutos);

                } catch (Exception e) {
                    Log.e(TAG, "Falha na chamada da API");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
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