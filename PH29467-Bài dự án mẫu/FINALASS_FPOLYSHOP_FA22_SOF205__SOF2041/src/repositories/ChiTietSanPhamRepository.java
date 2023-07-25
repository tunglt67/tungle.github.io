/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import domainmodels.ChiTietSanPham;
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
public class ChiTietSanPhamRepository {

    public List<ChiTietSanPham> getAll() {
        List<ChiTietSanPham> list = new ArrayList<>();
        String query = """
                       SELECT [Id]
                             ,[IdSP]
                             ,[IdNsx]
                             ,[IdMauSac]
                             ,[IdDongSP]
                             ,[NamBH]
                             ,[MoTa]
                             ,[SoLuongTon]
                             ,[GiaNhap]
                             ,[GiaBan]
                         FROM [dbo].[ChiTietSP]
                       """;

        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
                        rs.getInt(8), rs.getDouble(9), rs.getDouble(10));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPhamViewModel> getAllSPV() {
        List<SanPhamViewModel> list = new ArrayList<>();
        String query = """
                     SELECT ChiTietSP.id ,SanPham.Ma, SanPham.Ten,NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan FROM ChiTietSP 
                                     Join SanPham on ChiTietSP.idSP = SanPham.id
                                     order by SanPham.Ma
                       """;

        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                int nambh = Integer.parseInt(rs.getString(4));
                String mota = rs.getString(5);
                int SL = Integer.parseInt(rs.getString(6));
                double gianhap = Double.parseDouble(rs.getString(7));
                double giaBan = Double.parseDouble(rs.getString(8));
                list.add(new SanPhamViewModel(id, sp, nambh, mota, SL, gianhap, giaBan));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }

    }

    public boolean insertCTSP(ChiTietSanPham ctsp) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[ChiTietSP]
                                  ([Id]
                                  ,[IdSP]
                                  ,[IdNsx]
                                  ,[IdMauSac]
                                  ,[IdDongSP]
                                  ,[NamBH]
                                  ,[MoTa]
                                  ,[SoLuongTon]
                                  ,[GiaNhap]
                                  ,[GiaBan])
                            VALUES
                                  (?,?,?,?,?,?,?,?,?,?)
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ctsp.getId());
            ps.setObject(2, ctsp.getIdSP());
            ps.setObject(3, ctsp.getIdNSX());
            ps.setObject(4, ctsp.getIdMau());
            ps.setObject(5, ctsp.getIdDongSP());
            ps.setObject(6, ctsp.getNamBH());
            ps.setObject(7, ctsp.getMoTa());
            ps.setObject(8, ctsp.getSoLuongTon());
            ps.setObject(9, ctsp.getGiaNhap());
            ps.setObject(10, ctsp.getGiaBan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ChiTietSanPham ctsp, String id) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[ChiTietSP]
                         SET [IdSP] = ?
                            ,[IdNsx] = ?
                            ,[IdMauSac] = ?
                            ,[IdDongSP] = ?
                            ,[NamBH] = ?
                            ,[MoTa] = ?
                            ,[SoLuongTon] = ?
                            ,[GiaNhap] = ?
                            ,[GiaBan] = ?
                       WHERE Id = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ctsp.getIdSP());
            ps.setObject(2, ctsp.getIdNSX());
            ps.setObject(3, ctsp.getIdMau());
            ps.setObject(4, ctsp.getIdDongSP());
            ps.setObject(5, ctsp.getNamBH());
            ps.setObject(6, ctsp.getMoTa());
            ps.setObject(7, ctsp.getSoLuongTon());
            ps.setObject(8, ctsp.getGiaNhap());
            ps.setObject(9, ctsp.getGiaBan());
            ps.setObject(10, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(SanPhamViewModel ctsp, int soLuong) {
        int check = 0;
        int SLSP = ctsp.getSlTon()- soLuong;
        String query = "UPDATE ChiTietSP SET SoLuongTon = ? WHERE Id = ?  ";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, SLSP);
            ps.setObject(2, ctsp.getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        int check = 0;
        String query = """
                     DELETE FROM [dbo].[ChiTietSP]
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

    public List<String> getListNSX() {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[NSX]
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

    public String getIDByNSX(String ten) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[NSX]
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

    public String getNSXByID(String id) {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[NSX]
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

    public List<String> getListMau() {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[MauSac]
                       Order By [Ma] asc
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String m = rs.getString(1);
                lists.add(m);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByMau(String ten) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[MauSac]
                       Where [Ten] = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String m = rs.getString(1);
                return m;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getMauByID(String id) {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[MauSac]
                       Where [Id] = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String m = rs.getString(1);
                return m;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<String> getListDongSP() {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[DongSP]
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

     public String getIDByDongSP(String ten) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[DongSP]
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

    public String getDongSPByID(String id) {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[DongSP]
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

    public List<String> getListSP() {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[SanPham]
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

    public String getIDBySP(String ten) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[SanPham]
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

    public String getSPByID(String id) {
        String query = """
                       SELECT [Ten]
                         FROM [dbo].[SanPham]
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

    public SanPhamViewModel getCTSPByid(String idctSP) {
        String query = """
                       SELECT ChiTietSP.id ,SanPham.Ma, SanPham.Ten,NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan FROM ChiTietSP 
                                                            Join SanPham on ChiTietSP.idSP = SanPham.id WHERE ChiTietSP.id = ?
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            SanPhamViewModel SP = null;
            ps.setObject(1, idctSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                int namBH = Integer.parseInt(rs.getString(4));
                String moTa = rs.getString(5);
                int soLuong = Integer.parseInt(rs.getString(6));
                double giaNhap = Double.parseDouble(rs.getString(7));
                double giaBan = Double.parseDouble(rs.getString(8));
                SP = new SanPhamViewModel(id, sp, namBH, moTa, soLuong, giaNhap, giaBan);
            }
            return SP;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }

    public List<SanPhamViewModel> search(String keyWord) {
        List<SanPhamViewModel> list = new ArrayList<>();
        String query = """
                       SELECT ChiTietSP.id, SanPham.Ma, SanPham.Ten, NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan FROM ChiTietSP 
                                                            Join SanPham on ChiTietSP.idSP = SanPham.id
                                                            WHERE SanPham.Ten like CONCAT('%',?,'%') 
                                            OR SanPham.Ma like CONCAT('%',?,'%') 
                                            order by SanPham.Ma
                       """;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, keyWord);
            ps.setObject(2, keyWord);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                int nambh = Integer.parseInt(rs.getString(4));
                String mota = rs.getString(5);
                int SL = Integer.parseInt(rs.getString(6));
                double gianhap = Double.parseDouble(rs.getString(7));
                double giaBan = Double.parseDouble(rs.getString(8));
                list.add(new SanPhamViewModel(id, sp, nambh, mota, SL, gianhap, giaBan));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }

    }
}
