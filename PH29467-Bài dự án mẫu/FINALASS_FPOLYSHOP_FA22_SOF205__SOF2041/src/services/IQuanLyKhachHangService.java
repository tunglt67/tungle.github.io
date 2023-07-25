/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.KhachHang;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyKhachHangService {

    List<KhachHang> getAllKhachHang();

    String save(KhachHang kh);

    String update(String ma, KhachHang kh,int index);

    String delete(String ma);
}
