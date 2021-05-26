package vku.tqtu.appbanhangck.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import vku.tqtu.appbanhangck.R;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ImageView imgquanlyhh = findViewById(R.id.imgquanlyhh);
        ImageView imgquanlycuahang = findViewById(R.id.imgquanlycuahang);
        Picasso.get().load("https://haiquanonline.com.vn/stores/news_dataimages/hoannm/082019/29/09/in_article/5212_10-Vcysmr.jpg").into(imgquanlyhh);
        Picasso.get().load("https://www.pdiam.com/wp-content/uploads/2018/07/07vopn_JDJA-min-300x208.jpg").into(imgquanlycuahang);
        imgquanlyhh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),QuanlyHanghoa.class);
                startActivity(intent);
            }
        });
    }
}