/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import repositories.HoaDonChiTietRepository;
import services.IQuanLyHoaDonChiTietService;
import viewmodels.GioHangViewModel;

/**
 *
 * @author Bânbân
 */
public class QuanLyHoaDonChiTietServiceImpl implements IQuanLyHoaDonChiTietService {

    HoaDonChiTietRepository HDCT = new HoaDonChiTietRepository();

    @Override
    public List<HoaDonChiTiet> getHDCTByMaHD(String ma) {
        return HDCT.getHDCTByMaHD(ma);
    }

    @Override
    public String addSP(HoaDonChiTiet hdct) {
        boolean add = HDCT.addSP(hdct);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public List<GioHangViewModel> getHDCTView(String ma) {
        List<HoaDonChiTiet> listHDCT = HDCT.getHDCTByMaHD(ma);
        List<GioHangViewModel> listGH = new ArrayList<>();
        int stt = 1;
        for (HoaDonChiTiet h : listHDCT) {
            listGH.add(new GioHangViewModel(stt, h.SPV().getSanPham().getMa(), h.SPV().getSanPham().getTen(), h.getSL(), h.SPV().getGiaBan(), h.getDonGia()));
            stt++;
        }
        System.out.println("add");
        return listGH;
    }

    @Override
    public String updateSL(HoaDonChiTiet hdct) {
        boolean update = HDCT.updateSL(hdct);
        if (update) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(HoaDonChiTiet hdct) {
        boolean delete = HDCT.delete(hdct);
        if (delete) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

}
