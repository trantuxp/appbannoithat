package vku.tqtu.appbanhangck.model;

public class Cuahang {
    private String tenshop;
    private String diachi;
    private String sodt;
    private String email;

    public Cuahang(String tenshop, String diachi, String sodt, String email) {
        this.tenshop = tenshop;
        this.diachi = diachi;
        this.sodt = sodt;
        this.email = email;
    }

    public String getTenshop() {
        return tenshop;
    }

    public void setTenshop(String tenshop) {
        this.tenshop = tenshop;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
