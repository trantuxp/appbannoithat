package vku.tqtu.appbanhangck.ultil;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import vku.tqtu.appbanhangck.model.result;
import vku.tqtu.appbanhangck.model.result_sanpham;

public interface ApiSanphammoinhat {
    ApiSanphammoinhat  ApiSanphammoinhat = new Retrofit.Builder()
            .baseUrl("http://192.168.1.72/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiSanphammoinhat.class) ;
    @GET("/serverAppCk/getspmoinhat.php")
    Call<result_sanpham> getSanphammoinhat();
}
