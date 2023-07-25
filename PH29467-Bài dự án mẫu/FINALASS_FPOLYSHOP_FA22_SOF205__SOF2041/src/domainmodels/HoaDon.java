/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import utilities.XDate;
import java.util.Date;

/**
 *
 * @author Bânbân
 */
public class HoaDon {

    private String id;
    private String ma;
    private Date ngayTao = XDate.now();
    private int tinhTrang;

    public HoaDon() {
    }

    public HoaDon(String ma, Date ngayTao, int tinhTrang) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String id, String ma, Date ngayTao, int tinhTrang) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
