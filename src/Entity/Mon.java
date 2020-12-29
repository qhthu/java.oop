/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author quach
 */
public class Mon {

    private int maMon;
    private String tenMon;
    private float gia;
    private String hinhAnh;
    private int trangThai;

    public Mon(int maMon, String tenMon, float gia, String hinhAnh, int trangThai) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
    }

    public int getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public float getGia() {
        return gia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
