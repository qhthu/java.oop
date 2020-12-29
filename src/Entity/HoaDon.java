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
public class HoaDon {

    private int maHD;
    private int maBan;
    private int trangThai;

    public HoaDon(int maHD, int maBan, int trangThai) {
        this.maHD = maHD;
        this.maBan = maBan;
        this.trangThai = trangThai;
    }

    public int getMaHD() {
        return maHD;
    }

    public int getMaBan() {
        return maBan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
