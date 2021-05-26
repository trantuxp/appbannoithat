package vku.tqtu.appbanhangck.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.adapter.QuanlyHhAdapter;
import vku.tqtu.appbanhangck.model.Sanpham;
import vku.tqtu.appbanhangck.model.result_sanpham;
import vku.tqtu.appbanhangck.model.result_sanphambydanhmuc;
import vku.tqtu.appbanhangck.ultil.ApiService;

public class QuanlyHanghoa extends AppCompatActivity {

    Toolbar toolbar;
    ListView listViewquanlyhh;
    Button btnthemhanghoa;
    QuanlyHhAdapter quanlyHhAdapter;
    ArrayList<Sanpham> mangquanlyhh;


    int id=0;
    String tenhang= "";
    int soluong=0;
    long dongia=0;
    String anh="";
    String ngay="";
    String mota="";
    int iddanhmuc=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_hanghoa);
        Anhxa();
        ActionToolBar();
        GetData();
        EventButtonAdd();
    }

    private void EventButtonAdd() {
        btnthemhanghoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Xulythongtinhanghoa.class);
                startActivity(intent);

            }
        });
    }

    private void ActionToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void GetData(){
        ApiService.apiService.gettatcasanpham().enqueue(new Callback<result_sanpham>() {
            @Override
            public void onResponse(Call<result_sanpham> call, Response<result_sanpham> response) {
                result_sanpham sanpham = response.body();

                for (int i = 0; i <sanpham.getData().size(); i++) {
                    id = sanpham.getData().get(i).getId();
                    tenhang = sanpham.getData().get(i).getTenhang();
                    soluong = sanpham.getData().get(i).getSoluong();
                    dongia = sanpham.getData().get(i).getDongia();
                    mota = sanpham.getData().get(i).getMota();
                    anh = sanpham.getData().get(i).getAnh();
                    ngay = sanpham.getData().get(i).getNgay();
                    iddanhmuc = sanpham.getData().get(i).getIddanhmuc();

                    mangquanlyhh.add(new Sanpham(id,tenhang,soluong,dongia,anh,ngay,mota,iddanhmuc));
                    quanlyHhAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<result_sanpham> call, Throwable t) {
                Toast.makeText(QuanlyHanghoa.this, "Hãy kiểm tra dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Anhxa() {
        toolbar = findViewById(R.id.toolbarquanlyhh);
        listViewquanlyhh = findViewById(R.id.listviewquanlyhh);
        btnthemhanghoa = findViewById(R.id.btnthemhanghoa);
        mangquanlyhh= new ArrayList<>();
        quanlyHhAdapter = new QuanlyHhAdapter(getApplicationContext(),mangquanlyhh);
        listViewquanlyhh.setAdapter(quanlyHhAdapter);


    }
}