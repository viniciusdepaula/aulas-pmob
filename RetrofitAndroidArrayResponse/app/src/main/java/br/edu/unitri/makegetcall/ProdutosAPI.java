package br.edu.unitri.makegetcall;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by viniciusdepaula
 */
public interface ProdutosAPI {

    /*
     * Anotação do endpoint usado pelo retrofit
    */

    @GET("v2/5b81648a3400008a00ecb333")
    Call<List<Produto>> getProdutos();

}
