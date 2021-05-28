package vku.tqtu.appbanhangck.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import vku.tqtu.appbanhangck.R;

public class Admin extends AppCompatActivity {

    Toolbar toolbar ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ImageView imgquanlyhh = findViewById(R.id.imgquanlyhh);
        ImageView imgquanlycuahang = findViewById(R.id.imgquanlycuahang);
        toolbar = findViewById(R.id.toolbaradmin);
        ActionBar();
        Picasso.get().load("https://haiquanonline.com.vn/stores/news_dataimages/hoannm/082019/29/09/in_article/5212_10-Vcysmr.jpg").into(imgquanlyhh);
        Picasso.get().load("https://www.pdiam.com/wp-content/uploads/2018/07/07vopn_JDJA-min-300x208.jpg").into(imgquanlycuahang);
        imgquanlyhh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),QuanlyHanghoa.class);
                startActivity(intent);
            }
        });
        imgquanlycuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),Xulythongtincuahang.class);
                startActivity(intent);
            }
        });
    }
    private void ActionBar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.account,menu);

        MenuItem item  ;
        if (Dangnhap.sessiontendn!=""){
            Toast.makeText(this, Dangnhap.sessiontendn+"", Toast.LENGTH_SHORT).show();
            item = menu.findItem(R.id.menutaikhoan);;
            item.setTitle(Dangnhap.sessiontendn);
            getMenuInflater().inflate(R.menu.dangxuat,menu);
        }
        else {
            getMenuInflater().inflate(R.menu.dangnhap,menu);
        }
        return true;
    }//tạo menu tới giỏ hàng


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//

        if (item.getItemId()==R.id.menudangnhap){
            Intent intent2 = new Intent(getApplicationContext(), Dangnhap.class);
            startActivity(intent2);
        }
        else if (item.getItemId()==R.id.menudangxuat){
            Dangnhap.sessiontendn="";
            Dangnhap.sessionmatkhaudn="";
            Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent2);
        }
        else {

        }
        return super.onOptionsItemSelected(item);
    }
}