/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.HoaDonChiTiet;
import java.util.List;
import viewmodels.GioHangViewModel;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyHoaDonChiTietService {

    List<HoaDonChiTiet> getHDCTByMaHD(String ma);

    String addSP(HoaDonChiTiet hdct);

    List<GioHangViewModel> getHDCTView(String ma);

    String updateSL(HoaDonChiTiet hdct);

    String delete(HoaDonChiTiet hdct);
}
