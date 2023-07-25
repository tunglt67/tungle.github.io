/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.HoaDon;
import domainmodels.HoaDonChiTiet;
import domainmodels.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DBConnection;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author Bânbân
 */
public class HoaDonChiTietRepository {

    public List<HoaDonChiTiet> getHDCTByMaHD(String ma) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        String query = """
                       SELECT HoaDon.id, HoaDon.Ma,HoaDon.NgayTao,HoaDon.TinhTrang,
                                            ChiTietSP.id,SanPham.Ma, SanPham.Ten, NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan,
                                            SoLuong,
                                            DonGia
                                            FROM HoaDonChiTiet 
                                            Join HoaDon ON HoaDon.id = HoaDonChiTiet.idHoaDon
                                            join ChiTietSP on ChiTietSP.id = HoaDonChiTiet.idChiTietSP
                                            Join SanPham on ChiTietSP.idSP = SanPham.id
                                             WHERE HoaDon.Ma = ?
                       """;

        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
                SanPham sp = new SanPham(rs.getString(6), rs.getString(7));
                int nambh = Integer.parseInt(rs.getString(8));
                String mota = rs.getString(9);
                int SL = Integer.parseInt(rs.getString(10));
                double gianhap = Double.parseDouble(rs.getString(11));
                double giaBan = Double.parseDouble(rs.getString(12));
                SanPhamViewModel spv = new SanPhamViewModel(rs.getString(5), sp, nambh, mota, SL, gianhap, giaBan);
                int soLuong = Integer.parseInt(rs.getString(13));
                double donGia = rs.getDouble(14);
                list.add(new HoaDonChiTiet(hd, spv, soLuong, donGia));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }

    public boolean addSP(HoaDonChiTiet hdct) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[HoaDonChiTiet]
                                  ([IdHoaDon]
                                  ,[IdChiTietSP]
                                  ,[SoLuong]
                                  ,[DonGia])
                            VALUES
                                  (?,?,?,?)
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getHoaDon().getId());
            ps.setObject(2, hdct.SPV().getId());
            ps.setObject(3, hdct.getSL());
            ps.setObject(4, hdct.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSL(HoaDonChiTiet hdct) {
        int check = 0;
        String query = """
                       UPDATE HoaDonChiTiet SET SoLuong = ?, DonGia = ? WHERE idHoaDon= ? and idChiTietSP = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getSL());
            ps.setObject(2, hdct.getDonGia());
            ps.setObject(3, hdct.getHoaDon().getId());
            ps.setObject(4, hdct.SPV().getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(HoaDonChiTiet hdct) {
        int check = 0;
        String query = """
                       DELETE FROM HoaDonChiTiet WHERE idHoaDon= ? and idChiTietSP = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getHoaDon().getId());
            ps.setObject(2, hdct.SPV().getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
