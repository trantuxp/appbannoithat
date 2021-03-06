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

public class DanhmucActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    DanhmucAdapter danhmucAdapter;
    ArrayList<Sanpham> mangsanphamtheodanhmuc;

    View footerview;
    boolean isloading=false;
    mHandler mHandler;
    boolean limitdata = false;

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
    int page =1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhmuc);
        Anhxa();
        //
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){ // nếu thành công
            getidloaisp();
            tenban = getIntent().getStringExtra("tendanhmuc");
            toolbar.setTitle(tenban);
            ActionToolBar();
            GetData(page);
            LoadmoreData();
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
    private void LoadmoreData() {

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem+visibleItemCount==totalItemCount && totalItemCount!=0 && isloading==false&& limitdata==false){
                    isloading=true;
                    Thread thread =new Thread();
                    thread.start();
                }
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


    private void GetData(int page){
        ApiService.apiService.getsanpham(page,idban).enqueue(new Callback<result_sanphambydanhmuc>() {
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
                Toast.makeText(DanhmucActivity.this, "Lỗi rồi nhe", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getidloaisp(){
        idban = getIntent().getIntExtra("idloaisanpham",-1);
    }
    private void Anhxa() {
        toolbar= findViewById(R.id.toolbarban);
        listView = findViewById(R.id.listviewban);
        mangsanphamtheodanhmuc = new ArrayList<>();
        danhmucAdapter = new DanhmucAdapter(getApplicationContext(), mangsanphamtheodanhmuc);
        listView.setAdapter(danhmucAdapter);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = layoutInflater.inflate(R.layout.progressbar,null);
        mHandler = new mHandler();

    }
    public class mHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0:
                    listView.addFooterView(footerview);
                    break;
                case 1:
                    GetData(++page);
                    isloading= false;
                    break;
            }
            super.handleMessage(msg);
        }
    }
    public class Thread extends java.lang.Thread {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }
}