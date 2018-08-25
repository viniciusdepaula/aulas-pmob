package br.edu.unitri.makegetcall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    static String TAG = MainActivity.class.getName();

    String url = "http://demo8055075.mockable.io/";

    List<String> listaProdutos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Leitor");
        produto.setMarca("Bematech");
        produto.setPreco(new BigDecimal(200));

        getRetrofitArray(produto);

    }

    void getRetrofitArray(Produto produto) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProdutosAPI service = retrofit.create(ProdutosAPI.class);

        Call<Response> call = service.addProduto(produto);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(retrofit.Response<Response> response, Retrofit retrofit) {

                try {

                    String msg = response.body().getMsg();
                    showToast(msg);

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

    void showToast(String msg) {

        Toast.makeText(this, msg,
                Toast.LENGTH_LONG).show();
    }
}