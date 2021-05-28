package vku.tqtu.appbanhangck.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.model.result_cuahang;
import vku.tqtu.appbanhangck.model.result_sanphambydanhmuc;
import vku.tqtu.appbanhangck.ultil.ApiService;

public class Xulythongtincuahang extends AppCompatActivity {

    Toolbar toolbar;
    EditText edittenshop,editdiachishop,editsodtshop,editemail;
    Button btnsua,btnxoa;
    String tenshop = "";
    String diachi = "";
    String sodtshop="";
    String email = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xulythongtincuahang2);
        Anhxa();
        GetData();
        EventButton();
        ActionToolBar();
    }
    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void EventButton() {

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenshop1=edittenshop.getText().toString().trim();
                String diachi1=editdiachishop.getText().toString().trim();
                String sodtshop1=editsodtshop.getText().toString().trim();
                String email1=editemail.getText().toString().trim();
                Toast.makeText(Xulythongtincuahang.this, tenshop1, Toast.LENGTH_SHORT).show();
                ApiService.apiService.suattcuahang(tenshop1,diachi1,sodtshop1,email1).enqueue(new Callback<result_sanphambydanhmuc>() {
                    public void onResponse(Call<result_sanphambydanhmuc> call, Response<result_sanphambydanhmuc> response) {
                    }
                    public void onFailure(Call<result_sanphambydanhmuc> call, Throwable t) {
                    }
                });
                finish();
                startActivity(getIntent());
            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService.apiService.xoattcuahang().enqueue(new Callback<result_sanphambydanhmuc>() {
                    public void onResponse(Call<result_sanphambydanhmuc> call, Response<result_sanphambydanhmuc> response) {
                    }
                    public void onFailure(Call<result_sanphambydanhmuc> call, Throwable t) {
                    }
                });
                finish();
                startActivity(getIntent());
            }
        });

    }

    private void Anhxa() {
        btnsua=findViewById(R.id.btnsuattch);
        btnxoa=findViewById(R.id.btnxoattch);
        toolbar = findViewById(R.id.toolbarcuahang);
        edittenshop = findViewById(R.id.editquanlytenshop);
        editdiachishop = findViewById(R.id.editquanlydiachishop);
        editsodtshop = findViewById(R.id.editquanlysodtshop);
        editemail = findViewById(R.id.editquanlyemailshop);

    }

    private void GetData() {
        ApiService.apiService.getcuahang().enqueue(new Callback<result_cuahang>() {
            @Override
            public void onResponse(Call<result_cuahang> call, Response<result_cuahang> response) {
                result_cuahang cuahang = response.body();
                if (cuahang.getData().size()>0){
                    tenshop = cuahang.getData().get(0).getTenshop();
                    diachi = cuahang.getData().get(0).getDiachi();
                    sodtshop = cuahang.getData().get(0).getSodt();
                    email = cuahang.getData().get(0).getEmail();
                    edittenshop.setText(tenshop+"");
                    editdiachishop.setText(diachi+"");
                    editsodtshop.setText(sodtshop+"");
                    editemail.setText(email+"");
                }

            }

            @Override
            public void onFailure(Call<result_cuahang> call, Throwable t) {

            }
        });
    }

}