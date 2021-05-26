package vku.tqtu.appbanhangck.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.model.Giohang;
import vku.tqtu.appbanhangck.model.Sanpham;

public class ChitietSanpham extends AppCompatActivity {

    Toolbar toolbarchitiet;
    TextView txtten,txtgia,txtmota;
    ImageView imgchitiet;
    Spinner spinner;
    Button btndatmua;
    int id=0;
    String tenchitiet= "";
    int soluongchitiet=0;
    long dongiachitiet=0;
    String anhchitiet="";
    String ngaychitiet="";
    String motachitiet="";
    int iddanhmuc=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_sanpham);
        Anhxa();
        ActionToolBar();// thanh menu ngang
        GetInformation(); // đổ dữ liệu vào
        CatchEventSpinner(); // tạo giá trị cho ô số lượng
        EventButton();// tạo sự kiện cho nút thêm giỏ hàng
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

    private void EventButton() {
        btndatmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (MainActivity.manggiohang.size() > 0) {
                        boolean exists = false;
                        int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                        for (int i = 0; i < MainActivity.manggiohang.size(); i++) {
                            if (MainActivity.manggiohang.get(i).getIdsp() == id) {
                                MainActivity.manggiohang.get(i).setSoluongsp(MainActivity.manggiohang.get(i).getSoluongsp() + sl);
                                if (MainActivity.manggiohang.get(i).getSoluongsp() >= 10) {
                                    MainActivity.manggiohang.get(i).setSoluongsp(10);

                                }
                                MainActivity.manggiohang.get(i).setGiasp(dongiachitiet * MainActivity.manggiohang.get(i).getSoluongsp());
                                exists = true;
                            }
                        }
                        if (exists == false) {
                            int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                            double giamoi = soluong * dongiachitiet;
                            MainActivity.manggiohang.add(new Giohang(id, tenchitiet, giamoi, anhchitiet, soluong));
                        }
                    } else {
                        int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                        double giamoi = soluong* dongiachitiet;
                        MainActivity.manggiohang.add(new Giohang(id,tenchitiet,giamoi,anhchitiet,soluong));
                    }
                Intent intent  = new Intent(getApplicationContext(),GiohangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CatchEventSpinner() {
        Integer[] soluong =new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(adapter);
    }

    private void GetInformation() {

        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id=sanpham.getId();
        tenchitiet=sanpham.getTenhang();
        soluongchitiet=sanpham.getSoluong();
        dongiachitiet=sanpham.getDongia();
        anhchitiet=sanpham.getAnh();
        ngaychitiet=sanpham.getNgay();
        motachitiet=sanpham.getMota();
        iddanhmuc=sanpham.getIddanhmuc();

        txtten.setText(tenchitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgia.setText("Giá: "+ decimalFormat.format(dongiachitiet)+ "Đ" );
        txtmota.setText(motachitiet);
        Picasso.get().load(anhchitiet).placeholder(R.drawable.imgload)
                .error(R.drawable.imgerror)
                .into(imgchitiet);

    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarchitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarchitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private  void Anhxa(){
        toolbarchitiet = findViewById(R.id.toolbarchitietsp);
        txtten = findViewById(R.id.texttenchitietsp);
        txtgia = findViewById(R.id.textgiachitietsp);
        txtmota = findViewById(R.id.txtmotachitietsanpham);
        imgchitiet = findViewById(R.id.imgchitietsp);
        spinner = findViewById(R.id.spinner);
        btndatmua = findViewById(R.id.btndatmua);


    }
}