package vku.tqtu.appbanhangck.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.adapter.BanAdapter;
import vku.tqtu.appbanhangck.model.Loaisp;
import vku.tqtu.appbanhangck.model.Sanpham;
import vku.tqtu.appbanhangck.model.result;
import vku.tqtu.appbanhangck.model.result_sanphambydanhmuc;
import vku.tqtu.appbanhangck.ultil.ApiService;
import vku.tqtu.appbanhangck.ultil.CheckConnection;

import com.google.android.material.navigation.NavigationView;
public class BanActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    BanAdapter banAdapter;
    ArrayList<Sanpham> mangban;

    View footerview;
    boolean isloading=false;
    mHandler mHandler;
    boolean limitdata = false;

    int idban=0;
    String tenban;
    int id=0;
    String tenhang= "";

    int soluong=0;
    double dongia=0;
    String anh="";
    String ngay="";
    String mota="";
    int iddanhmuc=0;
    int page =1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban);
        Anhxa();
        //
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){ // nếu thành công
            getidloaisp();
            tenban = getIntent().getStringExtra("tendanhmuc");
            toolbar.setTitle(tenban);
            ActionToolBar();
            getidloaisp();
            GetData(page);
            LoadmoreData();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối");
            finish();
        }
        
    }

    private void LoadmoreData() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ChitietSanpham.class);
                intent.putExtra("thongtinsanpham",mangban.get(position));
                startActivity(intent);
            }
        });
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
                if (sanpham!=null && sanpham.getData().size()!=2){
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

                        mangban.add(new Sanpham(id,tenhang,soluong,dongia,anh,ngay,mota,iddanhmuc));

                        banAdapter.notifyDataSetChanged();
                    }
                }else {
                    limitdata= true;
                    listView.removeFooterView(footerview);
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Đã hết dữ liệu");
                }

            }

            @Override
            public void onFailure(Call<result_sanphambydanhmuc> call, Throwable t) {
                Toast.makeText(BanActivity.this, "Lỗi rồi nhe", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getidloaisp(){
        idban = getIntent().getIntExtra("idloaisanpham",-1);
    }
    private void Anhxa() {
        toolbar= findViewById(R.id.toolbarban);
        listView = findViewById(R.id.listviewban);
        mangban = new ArrayList<>();
        banAdapter = new BanAdapter(getApplicationContext(),mangban);
        listView.setAdapter(banAdapter);
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