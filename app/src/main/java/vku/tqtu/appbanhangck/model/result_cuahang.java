package vku.tqtu.appbanhangck.model;

import java.util.List;

public class result_cuahang {
    private List<Cuahang> data;

    public result_cuahang(List<Cuahang> data) {
        this.data = data;
    }

    public List<Cuahang> getData() {
        return data;
    }

    public void setData(List<Cuahang> data) {
        this.data = data;
    }
}
