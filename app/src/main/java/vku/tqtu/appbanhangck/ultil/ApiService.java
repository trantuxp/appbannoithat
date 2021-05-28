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
import vku.tqtu.appbanhangck.model.Taikhoan;
import vku.tqtu.appbanhangck.model.result;
import vku.tqtu.appbanhangck.model.result_cuahang;
import vku.tqtu.appbanhangck.model.result_sanpham;
import vku.tqtu.appbanhangck.model.result_sanphambydanhmuc;
import vku.tqtu.appbanhangck.model.result_taikhoan;

import static vku.tqtu.appbanhangck.ultil.Server.localhost;

public interface ApiService {

    ApiService  apiService = new Retrofit.Builder()
            .baseUrl("https://websitent.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class) ;
    @GET("/serverAppCk/getloaisp.php")
    Call<result> getDanhmucApi();


    @GET("/serverAppCk/getsanpham.php")
    Call<result_sanphambydanhmuc> getsanpham(@Query("page") int i,
                                             @Query("idloaisp") int j);

    @GET("/serverAppCk/setthongtinkh.php")
    Call<result_sanphambydanhmuc> setthongtinkh(@Query("tenkhachhang") String ten,
                                                @Query("diachi") String diachi,
                                                @Query("sodienthoai") int sodt,
                                                @Query("email") String email,
                                                @Query("tongsanpham") int tongsp,
                                                @Query("tongtien") double tongtien);

    @GET("/serverAppCk/chitietdonhang.php")
    Call<result_sanphambydanhmuc> getchitietdonhang(@Query("json") String jsonArray);
    @GET("/serverAppCk/gettatcasanpham.php")
    Call<result_sanpham> gettatcasanpham();
    @GET("/serverAppCk/themhanghoa.php")
    Call<result_sanpham> themhanghoa(@Query("tensanpham") String tensp,
                                     @Query("soluong") int soluong,
                                     @Query("gia") long gia,
                                     @Query("anh") String anh,
                                     @Query("mota") String mota,
                                     @Query("iddanhmuc") int iddanhmuc);
    @GET("/serverAppCk/suahanghoa.php")
    Call<result_sanpham> suahanghoa(@Query("id") int id,
                                    @Query("tensanpham") String tensp,
                                     @Query("soluong") int soluong,
                                     @Query("gia") long gia,
                                     @Query("anh") String anh,
                                     @Query("mota") String mota,
                                     @Query("iddanhmuc") int iddanhmuc);
    @GET("/serverAppCk/Xoahanghoa.php")
    Call<result_sanpham> xoahanghoa(@Query("id") int id);

    @GET("/serverAppCk/getcuahang.php")
    Call<result_cuahang> getcuahang();

    @GET("/serverAppCk/gettaikhoan.php")
    Call<result_taikhoan> gettaikhoan();

    @GET("/serverAppCk/themtaikhoan.php")
    Call<result_taikhoan> themtaikhoan(@Query("tendn") String tendn,@Query("matkhau") String matkhau);

    @GET("/serverAppCk/gettimkiem.php")
    Call<result_sanphambydanhmuc> gettimkiem(@Query("noidungtim") String j);

    @GET("/serverAppCk/suattcuahang.php")
    Call<result_sanphambydanhmuc> suattcuahang(@Query("tenshop") String tenshop,
                                               @Query("diachi") String diachi,
                                               @Query("sodt") String sodt,
                                               @Query("email") String email);
    @GET("/serverAppCk/xoattcuahang.php")
    Call<result_sanphambydanhmuc> xoattcuahang();
}
