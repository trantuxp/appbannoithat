package vku.tqtu.appbanhangck.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import vku.tqtu.appbanhangck.R;
import vku.tqtu.appbanhangck.model.Sanpham;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {
   Context context;
   ArrayList<Sanpham> sanphamArrayList;

    public SanphamAdapter(Context context, ArrayList<Sanpham> sanphamArrayList) {
        this.context = context;
        this.sanphamArrayList = sanphamArrayList;
    }

    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sanphammoinhat,null);
        ItemHolder itemHolder = new ItemHolder(v);

        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Sanpham sanpham = sanphamArrayList.get(position);
        holder.txttensanpham.setText(sanpham.getTenhang());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText("Giá: "+decimalFormat.format(sanpham.getDongia())+" Đ");
        Picasso.get().load(sanpham.getAnh()).error(R.drawable.imgerror).into(holder.imghinhsanpham);
    }

    @Override
    public int getItemCount() {
        return sanphamArrayList.size();
    }

    public class ItemHolder extends  RecyclerView.ViewHolder{
        public ImageView imghinhsanpham;
        public TextView txttensanpham,txtgiasanpham;

        public ItemHolder(View itemView){
            super(itemView);
            imghinhsanpham = (ImageView)itemView.findViewById(R.id.imageviewsanpham);
            txtgiasanpham= (TextView) itemView.findViewById(R.id.textviewgiasanpham);
            txttensanpham= (TextView) itemView.findViewById(R.id.textviewtensanpham);


        }
    }
}
