/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import domainmodels.SanPham;

/**
 *
 * @author Bânbân
 */
public class SanPhamViewModel {

    private String id;
    private SanPham sanPham;
    private int NamBH;
    private String moTa;
    private int slTon;
    private double giaNhap;
    private double giaBan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPhamViewModel(String id, SanPham sanPham, int NamBH, String moTa, int slTon, double giaNhap, double giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.NamBH = NamBH;
        this.moTa = moTa;
        this.slTon = slTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(SanPham sanPham, int NamBH, String moTa, int slTon, double giaNhap, double giaBan) {
        this.sanPham = sanPham;
        this.NamBH = NamBH;
        this.moTa = moTa;
        this.slTon = slTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getNamBH() {
        return NamBH;
    }

    public void setNamBH(int NamBH) {
        this.NamBH = NamBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSlTon() {
        return slTon;
    }

    public void setSlTon(int slTon) {
        this.slTon = slTon;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

}
