package vku.tqtu.appbanhangck.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.model.Loaisp;
import vku.tqtu.appbanhangck.model.result;
import vku.tqtu.appbanhangck.model.result_cuahang;
import vku.tqtu.appbanhangck.ultil.ApiService;

public class ThongtinActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView txttenshop,txtdiachishop,txtsodtshop,txtemailshop;
    String tenshop="";
    String diachi="";
    String sodt="";
    String email="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);
        Anhxa();
        getData();

    }

    private void getData() {
        ApiService.apiService.getcuahang().enqueue(new Callback<result_cuahang>() {
            @Override
            public void onResponse(Call<result_cuahang> call, Response<result_cuahang> response) {
                result_cuahang cuahang = response.body();
                tenshop = cuahang.getData().get(0).getTenshop();
                diachi = cuahang.getData().get(0).getDiachi();
                sodt = cuahang.getData().get(0).getSodt();
                email = cuahang.getData().get(0).getEmail();
                txttenshop.setText("Tên shop: "+tenshop+"");
                txtdiachishop.setText("Địa chỉ shop: "+diachi+"");
                txtsodtshop.setText("Số điện thoại shop: "+sodt+"");
                txtemailshop.setText("Email shop: "+email+"");
            }

            @Override
            public void onFailure(Call<result_cuahang> call, Throwable t) {

            }
        });
    }

    private void Anhxa() {
        linearLayout= findViewById(R.id.imgshop);
        txttenshop=findViewById(R.id.txttenshop);
        txtdiachishop=findViewById(R.id.txtdiachishop);
        txtsodtshop=findViewById(R.id.txtsodtshop);
        txtemailshop=findViewById(R.id.txtemailshop);

    }

}