/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.HoaDon;
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
public class HoaDonRepository {

    public List<HoaDon> getAllHD() {
        String query = """
                       SELECT id, Ma, NgayTao,TinhTrang FROM HoaDon order by CAST(substring(Ma,2,3) AS Varchar ) desc 
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getHDByTT(int tinhTrang) {
        String query = """
                      SELECT id, Ma, NgayTao,TinhTrang FROM HoaDon WHERE TinhTrang = ?
                                      order by CAST(substring(Ma,2,3) AS Varchar ) desc
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tinhTrang);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDon getHDByMa(String ma) {
        HoaDon hd = new HoaDon();
        String query = """
                      SELECT id, Ma, NgayTao,TinhTrang FROM HoaDon WHERE Ma = ?
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
            }
            return hd;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDon hd) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[HoaDon]
                                  ([Ma]
                                  ,[NgayTao]
                                  ,[TinhTrang]
                                  )
                            VALUES
                                  (?,?,?)
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hd.getMa());
            ps.setObject(2, hd.getNgayTao());
            ps.setObject(3, 0);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean thanhToan(HoaDon hd) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[HoaDon]
                          SET [TinhTrang] = 1
                        WHERE Ma = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hd.getMa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
