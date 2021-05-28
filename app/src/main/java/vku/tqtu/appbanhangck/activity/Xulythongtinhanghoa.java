package vku.tqtu.appbanhangck.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.model.Sanpham;
import vku.tqtu.appbanhangck.model.result_sanpham;
import vku.tqtu.appbanhangck.ultil.ApiService;

public class Xulythongtinhanghoa extends AppCompatActivity {
    String arr[]={
            "Ghế",
            "Bàn ăn",
            "Giường",
            "Sofa"};
    int id;
    String ten="";
    int sl=0;
    long gia=0;
    String anh="";
    String mota="";
    ArrayAdapter<String> adapter;

    int iddanhmuc;
    EditText edittenhh,editsoluonghh,editgiahh,editanhhh,editmotahh;
    Spinner spinneriddanhmuc;
    Button btnquaylai,btnxacnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xulythongtinhanghoa);
        Anhxa();

        EventButtonFix();
        EventButtonAdd();
    }

    private void EventButtonFix() {
        id = getIntent().getIntExtra("id",-1);
        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        if (sanpham!=null){
            edittenhh.setText(sanpham.getTenhang());
            editsoluonghh.setText(sanpham.getSoluong()+"");
            editgiahh.setText(sanpham.getDongia()+"");
            editanhhh.setText(sanpham.getAnh());
            editmotahh.setText(sanpham.getMota());
            spinneriddanhmuc.setSelection(sanpham.getIddanhmuc()-1);
        }
    }

    private void EventButtonAdd() {

        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ten =edittenhh.getText().toString().trim();
                String getsl=editsoluonghh.getText().toString().trim();
                String getgia=editgiahh.getText().toString().trim();
                anh =editanhhh.getText().toString().trim();
                mota =editmotahh.getText().toString().trim();

                if (ten.length()>0&&getsl.length()>0&&getgia.length()>0&&anh.length()>0&&mota.length()>0) {
                    sl =Integer.parseInt(editsoluonghh.getText().toString().trim());
                    gia =Long.parseLong(editgiahh.getText().toString().trim());
                    if (id>0){

                        ApiService.apiService.suahanghoa(id,ten,sl,gia,anh,mota,iddanhmuc).enqueue(new Callback<result_sanpham>() {
                            public void onResponse(Call<result_sanpham> call, Response<result_sanpham> response) {
                            }
                            public void onFailure(Call<result_sanpham> call, Throwable t) {
                            }
                        });

                        Intent intent = new Intent(getApplicationContext(),QuanlyHanghoa.class);
                        startActivity(intent);
                    }else {

                        ApiService.apiService.themhanghoa(ten,sl,gia,anh,mota,iddanhmuc).enqueue(new Callback<result_sanpham>() {
                            public void onResponse(Call<result_sanpham> call, Response<result_sanpham> response) {
                            }
                            public void onFailure(Call<result_sanpham> call, Throwable t) {
                            }
                        });

                        Intent intent = new Intent(getApplicationContext(),QuanlyHanghoa.class);
                        startActivity(intent);
                    }

                }
                else {
                    Toast.makeText(Xulythongtinhanghoa.this, "Hãy kiểm tra lại kết nối ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        edittenhh= findViewById(R.id.edittensanpham);
        editsoluonghh= findViewById(R.id.editsoluongsanpham);
        editgiahh= findViewById(R.id.editgiasanpham);
        editanhhh= findViewById(R.id.editanhsanpham);
        editmotahh= findViewById(R.id.editmotasanpham);
        spinneriddanhmuc= findViewById(R.id.spinneriddanhmuc);
        btnquaylai= findViewById(R.id.btnhuydienthongtinhh);
        btnxacnhan= findViewById(R.id.btnxacnhanhh);
        adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spinneriddanhmuc.setAdapter(adapter);
        spinneriddanhmuc.setOnItemSelectedListener(new Xulythongtinhanghoa.MyProcessEvent());

    }

    private class MyProcessEvent implements
            AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0,
                                   View arg1,
                                   int arg2,
                                   long arg3) {
            iddanhmuc=arg2+1;
        }
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
}