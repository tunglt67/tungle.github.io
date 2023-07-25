/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.SanPham;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bânbân
 */
public class SanPhamRepository {

    public List<SanPham> getAll() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[Ten]
                        FROM [dbo].[SanPham]
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insertSP(SanPham sp) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[SanPham]
                                 ([Ma]
                                 ,[Ten])
                           VALUES
                                 (?,?)
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String ma, SanPham sp) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[SanPham]
                         SET [Ma] = ?
                            ,[Ten] = ?
                       WHERE [Ma] = ?
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = """
                     DELETE FROM [dbo].[SanPham]
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

    public SanPham getSPByMa(String ma) {
        SanPham sp = null;
        String query = "SELECT * FROM SanPham WHERE Ma = ? ";

        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            return sp;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
