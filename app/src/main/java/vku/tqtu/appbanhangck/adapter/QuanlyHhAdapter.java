package vku.tqtu.appbanhangck.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.activity.QuanlyHanghoa;
import vku.tqtu.appbanhangck.activity.Xulythongtinhanghoa;
import vku.tqtu.appbanhangck.model.Sanpham;
import vku.tqtu.appbanhangck.model.result_sanpham;
import vku.tqtu.appbanhangck.ultil.ApiService;

public class QuanlyHhAdapter extends BaseAdapter {

    Context context;
    ArrayList<Sanpham> mangquanlyhh;

    public QuanlyHhAdapter(Context context, ArrayList<Sanpham> mangquanlyhh) {
        this.context = context;
        this.mangquanlyhh = mangquanlyhh;
    }

    public int getCount() {
        return mangquanlyhh.size();
    }

    @Override
    public Object getItem(int position) {
        return mangquanlyhh.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        public TextView txttenhh,txtsoluonghh,txtgiahh;
        public Button btnsuahh,btnxoahh;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (view ==null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // giúp get được service là layout của chúng ta ra
            view = inflater.inflate(R.layout.dong_quanlyhanghoa, null); // view = giao dien dòng của listview ,view để vẽ
            viewHolder.txttenhh= (TextView)view.findViewById(R.id.txttenhh);
            viewHolder.txtsoluonghh= (TextView)view.findViewById(R.id.txtsoluonghh);
            viewHolder.txtgiahh= (TextView)view.findViewById(R.id.txtgiahh);
            viewHolder.btnsuahh= view.findViewById(R.id.btnsuahanghoa);
            viewHolder.btnxoahh= view.findViewById(R.id.btnxoahanghoa);

            view.setTag(viewHolder);
        }
        else {
            viewHolder =(ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.txttenhh.setText(sanpham.getTenhang()+"");
        viewHolder.txtsoluonghh.setText(sanpham.getSoluong()+"");
        viewHolder.txtgiahh.setText(sanpham.getDongia()+"");

        viewHolder.btnsuahh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Xulythongtinhanghoa.class);
                intent.putExtra("id",sanpham.getId());
                intent.putExtra("thongtinsanpham",mangquanlyhh.get(position));
                context.startActivity(intent);
            }
        });
        viewHolder.btnxoahh.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ApiService.apiService.xoahanghoa(sanpham.getId()).enqueue(new Callback<result_sanpham>() {
                    public void onResponse(Call<result_sanpham> call, Response<result_sanpham> response) {

                    }

                    public void onFailure(Call<result_sanpham> call, Throwable t) {

                    }
                });
                Intent intent = new Intent(context,QuanlyHanghoa.class);
                context.startActivity(intent);
                return true;

            }

        });
        return view;
    }
}
