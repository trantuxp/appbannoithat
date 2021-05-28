package vku.tqtu.appbanhangck.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.model.Taikhoan;
import vku.tqtu.appbanhangck.model.result_taikhoan;
import vku.tqtu.appbanhangck.ultil.ApiService;


public class Dangnhap extends AppCompatActivity {

    EditText edittendangnhap,editmatkhaudangnhap;
    Button btndangky,btndangnhap;
    int id=-1;
    String tendn="",matkhaudn="";
    public static int vaitro=0;
    int taikhoantontai=0;
    public static String sessiontendn="",sessionmatkhaudn="";
    public static ArrayList<Taikhoan> mangtaikhoan;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        Anhxa();
        EventButton();
    }

    private void EventButton() {
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Dangnhap.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false);// bấm ra ngoài mà k tắt
                dialog.setContentView(R.layout.dangky);
                final EditText edittendangky = (EditText)dialog.findViewById(R.id.edittendangky);
                final EditText editmatkhaudangky =(EditText) dialog.findViewById(R.id.editmatkhaudangky);
                Button btnhuy = (Button)dialog.findViewById(R.id.btnhuydangky);
                Button btnxacnhandangky =(Button) dialog.findViewById(R.id.btnxacnhandangky);

                btnxacnhandangky.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edittendangky.getText().length()!=0&&editmatkhaudangky.getText().length()!=0) {
                            tendn = edittendangky.getText().toString().trim();
                            matkhaudn = editmatkhaudangky.getText().toString().trim();

                            ApiService.apiService.gettaikhoan().enqueue(new Callback<result_taikhoan>() {
                                public void onResponse(Call<result_taikhoan> call, Response<result_taikhoan> response) {
                                    result_taikhoan taikhoan = response.body();
                                    for (int i=0;i<taikhoan.getData().size();i++){
                                        if (tendn.equals(taikhoan.getData().get(i).getTendn())
                                                && matkhaudn.equals(taikhoan.getData().get(i).getMatkhau())){
                                           taikhoantontai=1;

                                        }
                                    }
                                    if (taikhoantontai==0){
                                        ApiService.apiService.themtaikhoan(tendn,matkhaudn).enqueue(new Callback<result_taikhoan>() {
                                            @Override
                                            public void onResponse(Call<result_taikhoan> call, Response<result_taikhoan> response) {

                                            }

                                            @Override
                                            public void onFailure(Call<result_taikhoan> call, Throwable t) {

                                            }
                                        });
                                        edittendangnhap.setText(tendn);
                                        editmatkhaudangnhap.setText(matkhaudn);
                                        dialog.cancel();
                                    }
                                    else {
                                        Toast.makeText(Dangnhap.this, "Tên đăng nhập đã tồn tại", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                public void onFailure(Call<result_taikhoan> call, Throwable t) {
                                    Toast.makeText(Dangnhap.this, "Hãy kiểm tra lại dữ liệu", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        else Toast.makeText(Dangnhap.this, "hãy điền đủ thông tin", Toast.LENGTH_SHORT).show();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittendangnhap.getText().length()!=0&&editmatkhaudangnhap.getText().length()!=0){
                    String tendn=edittendangnhap.getText().toString().trim();
                    String matkhaudn=editmatkhaudangnhap.getText().toString().trim();

                    ApiService.apiService.gettaikhoan().enqueue(new Callback<result_taikhoan>() {
                        @Override
                        public void onResponse(Call<result_taikhoan> call, Response<result_taikhoan> response) {
                            result_taikhoan taikhoan = response.body();
                            for (int i=0;i<taikhoan.getData().size();i++){
                                if (tendn.equals(taikhoan.getData().get(i).getTendn())
                                        && matkhaudn.equals(taikhoan.getData().get(i).getMatkhau())){
                                    Toast.makeText(Dangnhap.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                    sessiontendn=taikhoan.getData().get(i).getTendn();
                                    sessionmatkhaudn=taikhoan.getData().get(i).getMatkhau();
                                    vaitro=taikhoan.getData().get(i).getVaitro();
                                    if (vaitro!=0){
                                        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }else {
                                        Intent intent =new Intent(getApplicationContext(),Admin.class);
                                        startActivity(intent);
                                    }
                                }
                            }
                            if (sessiontendn=="") {
                                Toast.makeText(Dangnhap.this, "Bạn đã đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                                sessiontendn = "";
                            }
                        }

                        public void onFailure(Call<result_taikhoan> call, Throwable t) {
                            Toast.makeText(Dangnhap.this, "Hãy kiểm tra lại dữ liệu", Toast.LENGTH_SHORT).show();
                        }
                    });


                }else {
                    Toast.makeText(Dangnhap.this, "Mời bạn điền đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Anhxa() {
        edittendangnhap= findViewById(R.id.edittendangnhap);
        editmatkhaudangnhap= findViewById(R.id.editmatkhaudangnhap);
        btndangky= findViewById(R.id.btndangky);
        btndangnhap= findViewById(R.id.btndangnhap);

        if (mangtaikhoan!=null){

        }
        else  {
            mangtaikhoan= new ArrayList<>();
        }
    }
}