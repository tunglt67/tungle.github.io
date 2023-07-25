/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.MauSac;
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
public class MauSacRepository {

    public List<MauSac> getAll() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[Ten]
                        FROM [dbo].[MauSac]
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<MauSac> list = new ArrayList<>();
            while (rs.next()) {
                MauSac ms = new MauSac(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(ms);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insertCV(MauSac ms) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[MauSac]
                                 ([Ma]
                                 ,[Ten])
                           VALUES
                                 (?,?)
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String ma, MauSac ms) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[MauSac]
                         SET [Ma] = ?
                            ,[Ten] = ?
                       WHERE [Ma] = ?
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getTen());
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
                     DELETE FROM [dbo].[MauSac]
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
