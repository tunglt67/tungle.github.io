/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.ChiTietSanPham;
import java.util.List;
import viewmodels.ChiTietSanPhamViewModel;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyChiTietSanPhamService {

    List<ChiTietSanPham> getAllSP();

    String add(ChiTietSanPham sp);

    String delete(String id);

    String update(ChiTietSanPham sp, String id);

    String updateSL(SanPhamViewModel ctsp, int soLuong);

    List<String> getListNSX();

    String getNSXById(String id);

    String getIDByNSX(String ten);

    List<String> getListMau();

    String getMauById(String id);

    String getIDByMau(String ten);

    List<String> getListDongSP();

    String getDongSPById(String id);

    String getIDByDongSP(String ten);

    List<String> getListSP();

    String getSPById(String id);

    String getIDBySP(String ten);

    List<ChiTietSanPhamViewModel> DanhSachSP();

    List<ChiTietSanPhamViewModel> search(String keyWord);

    SanPhamViewModel getCTSPByid(String idctSP);
}
