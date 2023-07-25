/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import java.util.Date;

/**
 *
 * @author Bânbân
 */
public class NhanVien {

    private String id;
    private String ma;
    private String ten;
    private String gioiTinh;
    private Date NgaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private String idCH;
    private String idCV;
    private String idGuiBC;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(String ma, String matKhau) {
        this.ma = ma;
        this.matKhau = matKhau;
    }

    public NhanVien(String id, String ma, String ten, String gioiTinh, Date NgaySinh, String diaChi, String sdt, String matKhau, String idCH, String idCV, String idGuiBC, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.NgaySinh = NgaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCH = idCH;
        this.idCV = idCV;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getIdCH() {
        return idCH;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(String idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", NgaySinh=" + NgaySinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", matKhau=" + matKhau + ", idCH=" + idCH + ", idCV=" + idCV + ", idGuiBC=" + idGuiBC + ", trangThai=" + trangThai + '}';
    }

    public String getTinhTrang() {
        if (trangThai == 0) {
            return "Đã nghỉ việc";
        }
        return "Đang làm việc";
    }

    public Object[] toDataRow() {
        return new Object[]{id, ma, ten, gioiTinh, NgaySinh, diaChi, sdt, matKhau, idCH, idCV, getTinhTrang()};
    }

}
