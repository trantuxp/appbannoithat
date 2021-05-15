package vku.tqtu.appbanhangck.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class result {
    @SerializedName("ok")
    private String ok ;
    private List<Loaisp> data;

    public result(String ok, List<Loaisp> data) {
        this.ok = ok;
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<Loaisp> getData() {
        return data;
    }

    public void setData(List<Loaisp> data) {
        this.data = data;
    }
}
