package vku.tqtu.appbanhangck.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vku.tqtu.appbanhangck.R;

public class Dangnhap extends AppCompatActivity {

    EditText edittendangnhap,editmatkhaudangnhap;
    Button btndangky,btndangnhap;
    String tendn="",matkhaudn="";
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
                        tendn = edittendangky.getText().toString().trim();
                        matkhaudn= editmatkhaudangky.getText().toString().trim();

                        edittendangnhap.setText(tendn);
                        editmatkhaudangnhap.setText(matkhaudn);
                        dialog.cancel();
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
                    if (edittendangnhap.getText().toString().equals(tendn) && editmatkhaudangnhap.getText().toString().equals(matkhaudn)){
                        Toast.makeText(Dangnhap.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Dangnhap.this, "Bạn đã đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
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

    }
}