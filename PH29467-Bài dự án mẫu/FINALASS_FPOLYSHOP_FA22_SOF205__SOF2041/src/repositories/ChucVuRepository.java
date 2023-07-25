/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.ChucVu;
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
public class ChucVuRepository {
    public List<ChucVu> getAll() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[Ten]
                        FROM [dbo].[ChucVu]
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<ChucVu> list = new ArrayList<>();
            while (rs.next()) {
                ChucVu cv = new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(cv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insertCV(ChucVu cv) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[ChucVu]
                                 ([Ma]
                                 ,[Ten])
                           VALUES
                                 (?,?)
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String ma, ChucVu cv) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[ChucVu]
                         SET [Ma] = ?
                            ,[Ten] = ?
                       WHERE [Ma] = ?
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
             ps.setObject(1, cv.getMa());
             ps.setObject(2, cv.getTen());
             ps.setObject(3, ma);
             check = ps.executeUpdate();
             return check > 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
        
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = """
                     DELETE FROM [dbo].[ChucVu]
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
