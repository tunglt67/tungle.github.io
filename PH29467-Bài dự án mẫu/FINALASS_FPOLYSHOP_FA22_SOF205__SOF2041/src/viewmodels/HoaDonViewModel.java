/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import java.util.Date;
import utilities.XDate;

/**
 *
 * @author Bânbân
 */
public class HoaDonViewModel {

    private int stt;
    private String maHD;
    private Date ngayTao = XDate.now();
    private String tenNV;
    private int tinhTrang;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(int stt, String maHD, Date ngayTao, String tenNV, int tinhTrang) {
        this.stt = stt;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTrangThai() {
        switch (tinhTrang) {
            case 0:
                return "Chờ thanh toán";
            case 1:
                return "Đã thanh toán";
            case 2:
                return "Hủy";
            default:
                return "Tất cả";
        }
    }

    public Object[] toDataRow() {
        return new Object[]{stt, maHD, ngayTao, tenNV, getTrangThai()};
    }

}
