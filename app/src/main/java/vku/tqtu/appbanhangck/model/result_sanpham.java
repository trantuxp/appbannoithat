package vku.tqtu.appbanhangck.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class result_sanpham {
    @SerializedName("ok")
    private String ok ;
    private List<Sanpham> data;

    public result_sanpham(String ok, List<Sanpham> data) {
        this.ok = ok;
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<Sanpham> getData() {
        return data;
    }

    public void setData(List<Sanpham> data) {
        this.data = data;
    }
}
