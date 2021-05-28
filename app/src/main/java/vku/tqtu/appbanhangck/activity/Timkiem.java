package vku.tqtu.appbanhangck.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.adapter.DanhmucAdapter;
import vku.tqtu.appbanhangck.model.Sanpham;
import vku.tqtu.appbanhangck.model.result_sanphambydanhmuc;
import vku.tqtu.appbanhangck.ultil.ApiService;
import vku.tqtu.appbanhangck.ultil.CheckConnection;

public class Timkiem extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    DanhmucAdapter danhmucAdapter;
    ArrayList<Sanpham> mangsanphamtheodanhmuc;
    TextView txtnoiduntim;

    View footerview;
    boolean isloading=false;
    DanhmucActivity.mHandler mHandler;
    boolean limitdata = false;

    String noidungtim="";
    int idban=0;
    String tenban;
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
        setContentView(R.layout.activity_timkiem);
        Anhxa();
        //
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){ // nếu thành công
            getidloaisp();
            toolbar.setTitle("Tìm kiếm");
            ActionToolBar();
            GetData();
            setDataSanpham();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối");
            finish();
        }

    }

    private void setDataSanpham() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ChitietSanpham.class);
                intent.putExtra("thongtinsanpham", mangsanphamtheodanhmuc.get(position));
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.account,menu);
        getMenuInflater().inflate(R.menu.menu,menu);


        return true;
    }//tạo menu tới giỏ hàng
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent =new Intent(getApplicationContext(),GiohangActivity.class);
                startActivity(intent);
            case R.id.menudangnhap:
                Intent intent1 =new Intent(getApplicationContext(),Dangnhap.class);
                startActivity(intent1);
        }
        return super.onOptionsItemSelected(item);
    }//tạo sự kiện cho giỏ hàng

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
        Toast.makeText(this, noidungtim+"", Toast.LENGTH_LONG).show();
        ApiService.apiService.gettimkiem(noidungtim).enqueue(new Callback<result_sanphambydanhmuc>() {
            @Override
            public void onResponse(Call<result_sanphambydanhmuc> call, Response<result_sanphambydanhmuc> response) {
                result_sanphambydanhmuc sanpham = response.body();
                if (sanpham!=null && sanpham.getData().size()>0){
                    listView.removeFooterView(footerview);
                    for (int i = 0; i <sanpham.getData().size(); i++) {
                        id = sanpham.getData().get(i).getId();
                        tenhang = sanpham.getData().get(i).getTenhang();
                        soluong = sanpham.getData().get(i).getSoluong();
                        dongia = sanpham.getData().get(i).getDongia();
                        mota = sanpham.getData().get(i).getMota();
                        anh = sanpham.getData().get(i).getAnh();
                        ngay = sanpham.getData().get(i).getNgay();
                        iddanhmuc = sanpham.getData().get(i).getIddanhmuc();

                        mangsanphamtheodanhmuc.add(new Sanpham(id,tenhang,soluong,dongia,anh,ngay,mota,iddanhmuc));

                        danhmucAdapter.notifyDataSetChanged();
                    }
                }else {
                    limitdata= true;
                    listView.removeFooterView(footerview);
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Đã hết dữ liệu");
                }
            }

            @Override
            public void onFailure(Call<result_sanphambydanhmuc> call, Throwable t) {
                Toast.makeText(Timkiem.this, "Lỗi rồi nhé", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getidloaisp(){
        noidungtim = getIntent().getStringExtra("noidungtim");
        txtnoiduntim.setText("Nội dung tìm kiếm: "+noidungtim);

    }
    private void Anhxa() {
        txtnoiduntim= findViewById(R.id.txtnoidungtim);
        toolbar= findViewById(R.id.toolbarban);
        listView = findViewById(R.id.listviewban);
        mangsanphamtheodanhmuc = new ArrayList<>();
        danhmucAdapter = new DanhmucAdapter(getApplicationContext(), mangsanphamtheodanhmuc);
        listView.setAdapter(danhmucAdapter);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = layoutInflater.inflate(R.layout.progressbar,null);
        mHandler = new Timkiem().mHandler;

    }

}