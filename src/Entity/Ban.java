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
public class Ban {

    private int maBan;
    private int trangThai;

    public Ban(int maBan, int trangThai) {
        this.maBan = maBan;
        this.trangThai = trangThai;
    }

    public int getMaBan() {
        return maBan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
