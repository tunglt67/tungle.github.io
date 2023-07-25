/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;

/**
 *
 * @author Bânbân
 */
public class KhachHangRepository {

    public List<KhachHang> getAll() {
        String query = """
                      SELECT [Id]
                              ,[Ma]
                              ,[Ten]
                              ,[TenDem]
                              ,[Ho]
                              ,[NgaySinh]
                              ,[Sdt]
                              ,[DiaChi]
                              ,[ThanhPho]
                              ,[QuocGia]
                              ,[MatKhau]
                          FROM [dbo].[KhachHang]
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insertKH(KhachHang kh) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[KhachHang]
                                 ([Ma]
                                 ,[Ten]
                                 ,[TenDem]
                                 ,[Ho]
                                 ,[NgaySinh]
                                 ,[Sdt]
                                 ,[DiaChi]
                                 ,[ThanhPho]
                                 ,[QuocGia]
                                 ,[MatKhau])
                           VALUES
                                 (?,?,?,?,?,?,?,?,?,?)
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getSdt());
            ps.setObject(7, kh.getDiaChi());
            ps.setObject(8, kh.getThanhPho());
            ps.setObject(9, kh.getQuocGia());
            ps.setObject(10, kh.getMatKhau());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String ma, KhachHang kh) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[KhachHang]
                         SET [Ma] = ?
                            ,[Ten] = ?
                            ,[TenDem] = ?
                            ,[Ho] = ?
                            ,[NgaySinh] = ?
                            ,[Sdt] = ?
                            ,[DiaChi] = ?
                            ,[ThanhPho] = ?
                            ,[QuocGia] = ?
                            ,[MatKhau] = ?
                       WHERE Ma = ?
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getSdt());
            ps.setObject(7, kh.getDiaChi());
            ps.setObject(8, kh.getThanhPho());
            ps.setObject(9, kh.getQuocGia());
            ps.setObject(10, kh.getMatKhau());
            ps.setObject(11, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = """
                     DELETE FROM [dbo].[KhachHang]
                           WHERE Ma = ?
                     """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
