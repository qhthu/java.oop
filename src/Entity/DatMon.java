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
public class DatMon {

    private int maMon;
    private int maBan;
    private int soLuong;

    public DatMon(int maMon, int maBan, int soLuong) {
        this.maMon = maMon;
        this.maBan = maBan;
        this.soLuong = soLuong;
    }

    public int getMaMon() {
        return maMon;
    }

    public int getMaBan() {
        return maBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
