/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.HoaDon;
import java.util.ArrayList;
import java.util.List;
import repositories.HoaDonRepository;
import services.IQuanLyHoaDonService;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author Bânbân
 */
public class QuanLyHoaDonServiceImpl implements IQuanLyHoaDonService {

    HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public String save(HoaDon hd) {
        boolean addHD = hoaDonRepository.add(hd);
        if (addHD) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }

    @Override
    public List<HoaDonViewModel> getViewHoaDon() {
        List<HoaDonViewModel> listViewHD = new ArrayList<>();
        List<HoaDon> listHD = hoaDonRepository.getAllHD();
        int i = 1;
        for (HoaDon hd : listHD) {
            listViewHD.add(new HoaDonViewModel(i, hd.getMa(), hd.getNgayTao(), "", hd.getTinhTrang()));
            i++;
        }
        return listViewHD;
    }

    @Override
    public List<HoaDonViewModel> getViewHoaDonByTT(int tinhTrang) {
        List<HoaDonViewModel> listViewHD = new ArrayList<>();
        List<HoaDon> listHD = hoaDonRepository.getHDByTT(tinhTrang);
        int i = 1;
        for (HoaDon hd : listHD) {
            listViewHD.add(new HoaDonViewModel(i, hd.getMa(), hd.getNgayTao(), "", hd.getTinhTrang()));
            i++;
        }
        return listViewHD;
    }

    @Override
    public String thanhToan(HoaDon hd) {
        boolean update = hoaDonRepository.thanhToan(hd);
        if (update) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public HoaDon getHDByMa(String ma) {
        return hoaDonRepository.getHDByMa(ma);
    }

}
