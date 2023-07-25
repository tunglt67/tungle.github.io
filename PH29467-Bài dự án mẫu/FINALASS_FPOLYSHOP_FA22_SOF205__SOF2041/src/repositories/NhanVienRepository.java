/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.NhanVien;
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
public class NhanVienRepository {

    public List<NhanVien> getAll() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[GioiTinh]
                             ,[NgaySinh]
                             ,[DiaChi]
                             ,[Sdt]
                             ,[MatKhau]
                             ,[IdCH]
                             ,[IdCV]
                             ,[IdGuiBC]
                             ,[TrangThai]
                         FROM [dbo].[NhanVien]
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<NhanVien> list = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<NhanVien> getAccount() {
        String query = """
                       SELECT [Ma]
                             ,[MatKhau]
                       FROM [dbo].[NhanVien]
                       Order By [Ma] asc
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<NhanVien> list = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(NhanVien nv) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[NhanVien]
                                  ([Id]
                                  ,[Ma]
                                  ,[Ten]
                                  ,[TenDem]
                                  ,[Ho]
                                  ,[GioiTinh]
                                  ,[NgaySinh]
                                  ,[DiaChi]
                                  ,[Sdt]
                                  ,[MatKhau]
                                  ,[IdCH]
                                  ,[IdCV]
                                  ,[IdGuiBC]
                                  ,[TrangThai])
                            VALUES
                                  (?,?,?,?,?,?,?,?,?,?,?,?,?,?)
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getId());
            ps.setObject(2, nv.getMa());
            ps.setObject(3, nv.getTen());
            ps.setObject(4, null);
            ps.setObject(5, null);
            ps.setObject(6, nv.getGioiTinh());
            ps.setObject(7, nv.getNgaySinh());
            ps.setObject(8, nv.getDiaChi());
            ps.setObject(9, nv.getSdt());
            ps.setObject(10, nv.getMatKhau());
            ps.setObject(11, nv.getIdCH());
            ps.setObject(12, nv.getIdCV());
            ps.setObject(13, nv.getIdGuiBC());
            ps.setObject(14, nv.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(NhanVien nv, String id) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[NhanVien]
                          SET [Id] = ?
                             ,[Ma] = ?
                             ,[Ten] = ?
                             ,[TenDem] = ?
                             ,[Ho] = ?
                             ,[GioiTinh] = ?
                             ,[NgaySinh] = ?
                             ,[DiaChi] = ?
                             ,[Sdt] = ?
                             ,[MatKhau] = ?
                             ,[IdCH] = ?
                             ,[IdCV] = ?
                             ,[IdGuiBC] = ?
                             ,[TrangThai] = ?
                        WHERE [Id] = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getId());
            ps.setObject(2, nv.getMa());
            ps.setObject(3, nv.getTen());
            ps.setObject(4, null);
            ps.setObject(5, null);
            ps.setObject(6, nv.getGioiTinh());
            ps.setObject(7, nv.getNgaySinh());
            ps.setObject(8, nv.getDiaChi());
            ps.setObject(9, nv.getSdt());
            ps.setObject(10, nv.getMatKhau());
            ps.setObject(11, nv.getIdCH());
            ps.setObject(12, nv.getIdCV());
            ps.setObject(13, nv.getIdGuiBC());
            ps.setObject(14, nv.getTrangThai());
            ps.setObject(15, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        int check = 0;
        String query = """
                     DELETE FROM [dbo].[NhanVien]
                           WHERE Id = ?
                     """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<String> getListCH() {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[CuaHang]
                       Order By [Ma] asc
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String sp = rs.getString(1);
                lists.add(sp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByCH(String ten) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[CuaHang]
                       Where [Ten] = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getCHByID(String id) {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[CuaHang]
                       Where [Id] = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<String> getListCV() {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[ChucVu]
                       Order By [Ma] asc
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String cv = rs.getString(1);
                lists.add(cv);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByCV(String ten) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[ChucVu]
                       Where [Ten] = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cv = rs.getString(1);
                return cv;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getCVByID(String id) {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[ChucVu]
                       Where [Id] = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
