/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.NhaSX;
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
public class NhaSXRepository {

    public List<NhaSX> getAll() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[Ten]
                        FROM [dbo].[NSX]
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<NhaSX> list = new ArrayList<>();
            while (rs.next()) {
                NhaSX nsx = new NhaSX(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(nsx);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insertNSX(NhaSX nsx) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[NSX]
                                 ([Ma]
                                 ,[Ten])
                           VALUES
                                 (?,?)
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nsx.getMa());
            ps.setObject(2, nsx.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(String ma, NhaSX nsx) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[NSX]
                         SET [Ma] = ?
                            ,[Ten] = ?
                       WHERE [Ma] = ?
                      """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nsx.getMa());
            ps.setObject(2, nsx.getTen());
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
                     DELETE FROM [dbo].[NSX]
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
