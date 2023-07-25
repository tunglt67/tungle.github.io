/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Bânbân
 */
public class ChiTietSanPhamViewModel {

    private int Stt;
    private String id;
    private String MasanPham;
    private String TensanPham;
    private int NamBH;
    private String moTa;
    private int slTon;
    private double giaNhap;
    private double giaBan;

    public ChiTietSanPhamViewModel() {
    }

    public ChiTietSanPhamViewModel(int Stt, String id, String MasanPham, String TensanPham, int NamBH, String moTa, int slTon, double giaNhap, double giaBan) {
        this.Stt = Stt;
        this.id = id;
        this.MasanPham = MasanPham;
        this.TensanPham = TensanPham;
        this.NamBH = NamBH;
        this.moTa = moTa;
        this.slTon = slTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public String getMasanPham() {
        return MasanPham;
    }

    public void setMasanPham(String MasanPham) {
        this.MasanPham = MasanPham;
    }

    public String getTensanPham() {
        return TensanPham;
    }

    public void setTensanPham(String TensanPham) {
        this.TensanPham = TensanPham;
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

    public Object[] toDataRow() {
        return new Object[]{Stt, MasanPham, TensanPham, NamBH, moTa, slTon, giaNhap, giaBan};
    }
}
