package vku.tqtu.appbanhangck.model;

import java.util.List;

public class result_taikhoan {
    private List<Taikhoan> data;

    public List<Taikhoan> getData() {
        return data;
    }

    public void setData(List<Taikhoan> data) {
        this.data = data;
    }

    public result_taikhoan(List<Taikhoan> data) {
        this.data = data;
    }
}
