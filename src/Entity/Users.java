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
public class Users {

    private String TenND;
    private String matKhau;
    private String Email;

    public Users(String TenND, String matKhau, String Email) {
        this.TenND = TenND;
        this.matKhau = matKhau;
        this.Email = Email;
    }

    public String getTenND() {
        return TenND;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setTenND(String TenND) {
        this.TenND = TenND;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
