/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.DongSanPham;
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
public class DongSPRepository {

    public List<DongSanPham> getAll() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[Ten]
                        FROM [dbo].[DongSP]
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<DongSanPham> list = new ArrayList<>();
            while (rs.next()) {
                DongSanPham dsp = new DongSanPham(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(dsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insertDSP(DongSanPham dsp) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[DongSP]
                                 ([Ma]
                                 ,[Ten])
                           VALUES
                                 (?,?)
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, dsp.getMa());
            ps.setObject(2, dsp.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String ma, DongSanPham dsp) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[DongSP]
                         SET [Ma] = ?
                            ,[Ten] = ?
                       WHERE [Ma] = ?
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, dsp.getMa());
            ps.setObject(2, dsp.getTen());
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
                     DELETE FROM [dbo].[DongSP]
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
