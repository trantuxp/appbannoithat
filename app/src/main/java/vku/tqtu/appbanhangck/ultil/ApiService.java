package vku.tqtu.appbanhangck.ultil;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vku.tqtu.appbanhangck.model.Loaisp;
import vku.tqtu.appbanhangck.model.result;
import vku.tqtu.appbanhangck.model.result_sanpham;
import vku.tqtu.appbanhangck.model.result_sanphambydanhmuc;

import static vku.tqtu.appbanhangck.ultil.Server.localhost;

public interface ApiService {

    ApiService  apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.72/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class) ;
    @GET("/serverAppCk/getloaisp.php")
    Call<result> getDanhmucApi();

    @GET("/serverAppCk/getspmoinhat.php")
    Call<result_sanpham> getSanphammoinhat();
    @GET("/serverAppCk/getsanpham.php")
    Call<result_sanphambydanhmuc> getsanpham(@Query("page") int i,@Query("idloaisp") int j);
}