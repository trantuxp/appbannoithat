package vku.tqtu.appbanhangck.ultil;

import com.google.gson.JsonArray;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import vku.tqtu.appbanhangck.model.Loaisp;
import vku.tqtu.appbanhangck.model.result;
import vku.tqtu.appbanhangck.model.result_sanpham;
import vku.tqtu.appbanhangck.model.result_sanphambydanhmuc;

import static vku.tqtu.appbanhangck.ultil.Server.localhost;

public interface ApiService {

    ApiService  apiService = new Retrofit.Builder()
            .baseUrl("https://websitent.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class) ;
    @GET("/serverAppCk/getloaisp.php")
    Call<result> getDanhmucApi();

    @GET("/serverAppCk/getspmoinhat.php")
    Call<result_sanpham> getSanphammoinhat();
    @GET("/serverAppCk/getsanpham.php")
    Call<result_sanphambydanhmuc> getsanpham(@Query("page") int i,@Query("idloaisp") int j);
    @GET("/serverAppCk/thongtinkhachhang.php")
    Call<result_sanphambydanhmuc> getthongtinkhachhang(@Query("tenkhachang") String tenkh,@Query("sodienthoai") String sodt,@Query("email") String email);
    @GET("/serverAppCk/chitietdonhang.php")
    Call<result_sanphambydanhmuc> getchitietdonhang(@Query("json") String jsonArray);
}
