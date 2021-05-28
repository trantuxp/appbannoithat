package vku.tqtu.appbanhangck.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.model.result;
import vku.tqtu.appbanhangck.model.result_sanphambydanhmuc;
import vku.tqtu.appbanhangck.ultil.ApiService;
import vku.tqtu.appbanhangck.ultil.CheckConnection;

public class Thongtinkhachhang extends AppCompatActivity {

    EditText edittenkhachhang,editemail,editsdt,editdiachi;
    Button btnxacnhan,btntrove;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinkhachhang);
        Anhxa();
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
            EventButton();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nói");
        }
    }

    private void EventButton() {
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ten =edittenkhachhang.getText().toString().trim();
                String diachi =editdiachi.getText().toString().trim();
                int sodt =Integer.parseInt(editsdt.getText().toString().trim());
                String email =editemail.getText().toString().trim();
                int tongsp=0;
                double tongtien=0;
                for (int i=0;i<MainActivity.manggiohang.size();i++){
                    tongsp+=MainActivity.manggiohang.get(i).getSoluongsp();
                    tongtien+=MainActivity.manggiohang.get(i).getGiasp()*MainActivity.manggiohang.get(i).getSoluongsp();
                }
                Toast.makeText(Thongtinkhachhang.this, tongsp+":"+tongtien, Toast.LENGTH_SHORT).show();
                if (ten.length()>0&&diachi.length()>0&&email.length()>0){
                    ApiService.apiService.setthongtinkh(ten,diachi,sodt,email,tongsp,tongtien).enqueue(new Callback<result_sanphambydanhmuc>() {
                        @Override
                        public void onResponse(Call<result_sanphambydanhmuc> call, Response<result_sanphambydanhmuc> response) {

                        }

                        @Override
                        public void onFailure(Call<result_sanphambydanhmuc> call, Throwable t) {
                        }
                    });
                    JsonArray jsonArray = new JsonArray();
                    for (int i=0;i<MainActivity.manggiohang.size();i++){
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("masanpham",MainActivity.manggiohang.get(i).getIdsp());
                        jsonObject.addProperty("tensanpham",MainActivity.manggiohang.get(i).getTensp());
                        jsonObject.addProperty("soluongsanpham",MainActivity.manggiohang.get(i).getSoluongsp());
                        jsonObject.addProperty("giasanpham",MainActivity.manggiohang.get(i).getGiasp());
                        jsonArray.add(jsonObject);
                    }
                        String json= jsonArray.toString();
                    ApiService.apiService.getchitietdonhang(json).enqueue(new Callback<result_sanphambydanhmuc>() {
                        @Override
                        public void onResponse(Call<result_sanphambydanhmuc> call, Response<result_sanphambydanhmuc> response) {

                        }

                        @Override
                        public void onFailure(Call<result_sanphambydanhmuc> call, Throwable t) {

                        }
                    });
                }else {
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nói");
                }
            }
        });
    }

    private void Anhxa() {
        editdiachi= findViewById(R.id.edittextdiachikhachhang);
        edittenkhachhang= findViewById(R.id.edittexttenkhachhang);
        editsdt= findViewById(R.id.edittextsodtkhachhang);
        editemail= findViewById(R.id.edittextemail );
        btnxacnhan= findViewById(R.id.btnxacnhan);
        btntrove= findViewById(R.id.btntrove);
    }
}