package vku.tqtu.appbanhangck.model;

import java.io.Serializable;

public class Sanpham implements Serializable {
    public int id;
    public String tenhang;
    public int soluong;
    public long dongia;
    public String anh;
    public String ngay;
    public String mota;
    public int iddanhmuc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public long getDongia() {
        return dongia;
    }

    public void setDongia(long dongia) {
        this.dongia = dongia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getIddanhmuc() {
        return iddanhmuc;
    }

    public void setIddanhmuc(int iddanhmuc) {
        this.iddanhmuc = iddanhmuc;
    }

    public Sanpham(int id, String tenhang, int soluong, long dongia, String anh, String ngay, String mota, int iddanhmuc) {
        this.id = id;
        this.tenhang = tenhang;
        this.soluong = soluong;
        this.dongia = dongia;
        this.anh = anh;
        this.ngay = ngay;
        this.mota = mota;
        this.iddanhmuc = iddanhmuc;
    }
}
