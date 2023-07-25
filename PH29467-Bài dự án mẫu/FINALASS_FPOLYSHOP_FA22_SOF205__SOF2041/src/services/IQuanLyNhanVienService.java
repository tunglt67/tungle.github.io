/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.NhanVien;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyNhanVienService {

    List<NhanVien> getAllNhanVien();

    List<NhanVien> getAccount();

    String save(NhanVien nv);

    String update(NhanVien nv, String id);

    String delete(String id);

    String getIDByCH(String ten);

    List<String> getListCH();

    String getCHById(String id);

    String getIDByCV(String ten);

    List<String> getListCV();

    String getCVById(String id);
}
