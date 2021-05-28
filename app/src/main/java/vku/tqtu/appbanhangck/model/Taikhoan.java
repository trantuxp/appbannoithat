package vku.tqtu.appbanhangck.model;

public class Taikhoan {
    private String tendn;
    private String matkhau;
    private int vaitro;

    public Taikhoan(String tendn, String matkhau, int vaitro) {
        this.tendn = tendn;
        this.matkhau = matkhau;
        this.vaitro = vaitro;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getVaitro() {
        return vaitro;
    }

    public void setVaitro(int vaitro) {
        this.vaitro = vaitro;
    }
}
