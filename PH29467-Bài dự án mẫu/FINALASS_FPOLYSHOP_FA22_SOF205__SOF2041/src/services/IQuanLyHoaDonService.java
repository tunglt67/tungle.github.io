/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.HoaDon;
import java.util.List;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyHoaDonService {

    List<HoaDonViewModel> getViewHoaDon();

    HoaDon getHDByMa(String ma);

    List<HoaDonViewModel> getViewHoaDonByTT(int tinhTrang);

    String save(HoaDon hd);

    String thanhToan(HoaDon hd);

}
