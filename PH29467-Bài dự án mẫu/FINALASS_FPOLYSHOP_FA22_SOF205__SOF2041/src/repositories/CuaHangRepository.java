/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.CuaHang;
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
public class CuaHangRepository {

    public List<CuaHang> getAll() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[Ten]
                            ,[DiaChi]
                            ,[ThanhPho]
                            ,[QuocGia]
                        FROM [dbo].[CuaHang]
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<CuaHang> list = new ArrayList<>();
            while (rs.next()) {
                CuaHang ch = new CuaHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(ch);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insertCH(CuaHang ch) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[CuaHang]
                                 ([Ma]
                                 ,[Ten]
                                 ,[DiaChi]
                                 ,[ThanhPho]
                                 ,[QuocGia])
                           VALUES
                                 (?,?,?,?,?)
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getTen());
            ps.setObject(3, ch.getDiaChi());
            ps.setObject(4, ch.getThanhPho());
            ps.setObject(5, ch.getQuocGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String ma, CuaHang ch) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[CuaHang]
                         SET [Ma] = ?
                            ,[Ten] = ?
                            ,[DiaChi] = ?
                            ,[ThanhPho] = ?
                            ,[QuocGia] = ?
                       WHERE [Ma] = ?
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getTen());
            ps.setObject(3, ch.getDiaChi());
            ps.setObject(4, ch.getThanhPho());
            ps.setObject(5, ch.getQuocGia());
            ps.setObject(6, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = """
                     DELETE FROM [dbo].[CuaHang]
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
