/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import viewmodels.ChiTietSanPhamViewModel;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author Bânbân
 */
public class HoaDonChiTiet {

    private HoaDon hoaDon;
    private SanPhamViewModel SPV;
    private int SL;
    private double donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon hoaDon, SanPhamViewModel SPV, int SL, double donGia) {
        this.hoaDon = hoaDon;
        this.SPV = SPV;
        this.SL = SL;
        this.donGia = donGia;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPhamViewModel SPV() {
        return SPV;
    }

    public void setSPV(SanPhamViewModel SPV) {
        this.SPV = SPV;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

}
