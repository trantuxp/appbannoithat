package vku.tqtu.appbanhangck.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.adapter.LoaispAdapter;
import vku.tqtu.appbanhangck.adapter.SanphamAdapter;
import vku.tqtu.appbanhangck.model.Giohang;
import vku.tqtu.appbanhangck.model.Loaisp;
import vku.tqtu.appbanhangck.model.Sanpham;
import vku.tqtu.appbanhangck.model.result;
import vku.tqtu.appbanhangck.model.result_sanpham;
import vku.tqtu.appbanhangck.ultil.ApiSanphammoinhat;
import vku.tqtu.appbanhangck.ultil.ApiService;
import vku.tqtu.appbanhangck.ultil.CheckConnection;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;

    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;

    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamadapter;

    public static ArrayList<Giohang> manggiohang ;

    int id=0;
    String tenloaisp="";
    String hinhanhloaisp= "";

    int idsanppham=0;
    String tenhang= "";
    int soluong=0;
    long dongia=0;
    String anh="";
    String ngay="";
    String mota="";
    int iddanhmuc=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        // kiểm tra kết nối
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){ // nếu thành công
            ActionBar();// menu
            ActionViewFlipper(); // quảng cáo
            CatchOnItemListView();

        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối");
            finish();
        }

        GetDataApi();
    }

    private void GetDataApi() {
        ApiService.apiService.getDanhmucApi().enqueue(new Callback<result>() {
            @Override
            public void onResponse(Call<result> call, retrofit2.Response<result> response) {
                result loaisp = response.body();
//                        TextView txt = findViewById(R.id.text_san);
//                        txt.setText(loaisp.getData().get(2).getTenloaisp() + "");
                for (int i = 0; i <loaisp.getData().size(); i++) {
                    id = loaisp.getData().get(i).getId();
                    tenloaisp = loaisp.getData().get(i).getTenloaisp();
                    hinhanhloaisp = loaisp.getData().get(i).getHinhloaisp();
                    mangloaisp.add(new Loaisp(id, tenloaisp, hinhanhloaisp));

                    loaispAdapter.notifyDataSetChanged();
                }
                mangloaisp.add(loaisp.getData().size()+1,new Loaisp(2,"Thông tin",
                        "http://tienganhk12.com/Upload/Quiz/Icons/information-icon.jpg"));
                mangloaisp.add(loaisp.getData().size()+2,new Loaisp(1,"Admin","https://i.pinimg.com/originals/2d/5d/f2/2d5df21f3f00bce5285f081d20dce192.png"));

            }
            public void onFailure(Call<result> call, Throwable t) {
                TextView txt = findViewById(R.id.text_san) ;
                txt.setText("Lỗi rồi ");

            }
        });

        ApiSanphammoinhat.ApiSanphammoinhat.getSanphammoinhat().enqueue(new Callback<result_sanpham>() {
            @Override
            public void onResponse(Call<result_sanpham> call, Response<result_sanpham> response) {
                result_sanpham sanphammoinhat = response.body();
//                TextView txt = findViewById(R.id.text_san) ;
//                txt.setText("eassy rồi ");
                for (int i = 0; i <sanphammoinhat.getData().size(); i++) {
                    idsanppham = sanphammoinhat.getData().get(i).getId();
                    tenhang = sanphammoinhat.getData().get(i).getTenhang();
                    soluong = sanphammoinhat.getData().get(i).getSoluong();
                    dongia = sanphammoinhat.getData().get(i).getDongia();
                    anh = sanphammoinhat.getData().get(i).getAnh();
                    ngay = sanphammoinhat.getData().get(i).getNgay();
                    mota = sanphammoinhat.getData().get(i).getMota();
                    iddanhmuc = sanphammoinhat.getData().get(i).getIddanhmuc();


                    mangsanpham.add(new Sanpham(idsanppham, tenhang,soluong,dongia,anh,ngay, mota,iddanhmuc));
                    sanphamadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<result_sanpham> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "l^^o " , Toast.LENGTH_LONG ).show();
                TextView txt = findViewById(R.id.text_san) ;
                txt.setText("Lỗi rồi ");
            }
        });

        if (ManhinhSplash.tong<100){
            Intent intent = new Intent(MainActivity.this, ManhinhSplash.class);
            startActivity(intent);
        }

    }

    @Override
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

    private void CatchOnItemListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,MainActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent( MainActivity.this, DanhmucActivity.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            intent.putExtra("tendanhmuc",mangloaisp.get(position).getTenloaisp());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent( MainActivity.this, DanhmucActivity.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            intent.putExtra("tendanhmuc",mangloaisp.get(position).getTenloaisp());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent( MainActivity.this, DanhmucActivity.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            intent.putExtra("tendanhmuc",mangloaisp.get(position).getTenloaisp());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent( MainActivity.this, DanhmucActivity.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            intent.putExtra("tendanhmuc",mangloaisp.get(position).getTenloaisp());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent( MainActivity.this,ThongtinActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 6:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent( MainActivity.this,Admin.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }
    private void ActionViewFlipper(){
        ArrayList<String> mangquangcao= new ArrayList<>();
        mangquangcao.add("https://noithattrevietnam.com/uploaded/2018/08/1-mau-nha-dep-noi-that-hien-dai-can-80m2%20%281%29.jpg");
        mangquangcao.add("https://lh3.googleusercontent.com/proxy/CODpSiSngDXOjeiKfxsmkuzIxn9yHfB3TihcNukWHPNzNLzZLJvjuvqwJFU-cMGwh7Zb7BwyCVQQPAL3mM14aTyfK1pMkbzSsaJwhkeYnzjTa5Gooe2jgF8FiE_YG2t8EmILDjXV7hdOwnppkLuU96JJNBACWSj4YPO-VuICKz3KNCwCUYQtp5aSbls0s7LlkNqmEB0");
        mangquangcao.add("https://achi.vn/wp-content/uploads/2019/09/Mau-thiet-ke-noi-that-dep-hien-dai-nha-2-tang-achi-24420-10.jpg");
        mangquangcao.add("https://kientrucd8.com/wp-content/uploads/2019/09/thiet-ke-noi-that-phong-khach2-nha-mat-pho_no92.jpg");
        for (int i =0;i<mangquangcao.size();i++){
            ImageView imageView =new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animaton = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animaton_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_left);
        viewFlipper.setInAnimation(animaton);
        viewFlipper.setOutAnimation(animaton_out);


    }
    private void ActionBar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void anhxa(){
        toolbar = findViewById(R.id.toolbartrangchinh);
        viewFlipper =  findViewById(R.id.viewflipper);
        recyclerView =  findViewById(R.id.recyclerview);
        navigationView =  findViewById(R.id.navigation);
        listViewmanhinhchinh =  findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerlayout);
        mangloaisp = new ArrayList<>();
        mangloaisp.add(0,new Loaisp(0,"Trang chính",
                "https://png.pngtree.com/png-vector/20190129/ourlarge/pngtree-home-icon-graphic-design-template-vector-png-image_358126.jpg"));
        loaispAdapter = new LoaispAdapter(mangloaisp, getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);
        mangsanpham =new ArrayList<>();
        sanphamadapter = new SanphamAdapter(getApplicationContext(),mangsanpham);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(sanphamadapter);
        if (manggiohang!=null){

        }else {
            manggiohang= new ArrayList<>();

        }
    }
}