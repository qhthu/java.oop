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
public class Orders {

    private String tenMon;
    private int soLuong;
    private float gia;

    public Orders(String tenMon, int soLuong, float gia) {
        this.tenMon = tenMon;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getTenMon() {
        return tenMon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

}
