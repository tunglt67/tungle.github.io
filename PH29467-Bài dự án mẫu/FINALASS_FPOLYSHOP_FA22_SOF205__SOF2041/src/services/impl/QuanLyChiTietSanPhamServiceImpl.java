/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.ChiTietSanPham;
import java.util.ArrayList;
import java.util.List;
import repositories.ChiTietSanPhamRepository;
import services.IQuanLyChiTietSanPhamService;
import viewmodels.ChiTietSanPhamViewModel;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author Bânbân
 */
public class QuanLyChiTietSanPhamServiceImpl implements IQuanLyChiTietSanPhamService {

    ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    @Override
    public String add(ChiTietSanPham sp) {
        boolean addSP = chiTietSanPhamRepository.insertCTSP(sp);
        if (addSP) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean deleteSP = chiTietSanPhamRepository.delete(id);
        if (deleteSP) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(ChiTietSanPham sp, String id) {
        boolean updateSP = chiTietSanPhamRepository.update(sp, id);
        if (updateSP) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<String> getListNSX() {
        return chiTietSanPhamRepository.getListNSX();
    }

    @Override
    public String getNSXById(String id) {
        return chiTietSanPhamRepository.getNSXByID(id);
    }

    @Override
    public String getIDByNSX(String ten) {
        return chiTietSanPhamRepository.getIDByNSX(ten);
    }

    @Override
    public List<String> getListMau() {
        return chiTietSanPhamRepository.getListMau();
    }

    @Override
    public String getMauById(String id) {
        return chiTietSanPhamRepository.getMauByID(id);
    }

    @Override
    public String getIDByMau(String ten) {
        return chiTietSanPhamRepository.getIDByMau(ten);
    }

    @Override
    public List<String> getListDongSP() {
        return chiTietSanPhamRepository.getListDongSP();
    }

    @Override
    public String getDongSPById(String id) {
        return chiTietSanPhamRepository.getDongSPByID(id);
    }

    @Override
    public String getIDByDongSP(String ten) {
        return chiTietSanPhamRepository.getIDByDongSP(ten);
    }

    @Override
    public List<ChiTietSanPham> getAllSP() {
        return chiTietSanPhamRepository.getAll();
    }

    @Override
    public List<String> getListSP() {
        return chiTietSanPhamRepository.getListSP();
    }

    @Override
    public String getSPById(String id) {
        return chiTietSanPhamRepository.getSPByID(id);
    }

    @Override
    public String getIDBySP(String ten) {
        return chiTietSanPhamRepository.getIDBySP(ten);
    }

    @Override
    public String updateSL(SanPhamViewModel ctsp, int soLuong) {
        boolean updateCTSP = chiTietSanPhamRepository.update(ctsp, soLuong);
        if (updateCTSP) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<ChiTietSanPhamViewModel> DanhSachSP() {
        List<SanPhamViewModel> listSP = chiTietSanPhamRepository.getAllSPV();
        List<ChiTietSanPhamViewModel> listCTSP = new ArrayList<>();
        int i = 1;
        for (SanPhamViewModel S : listSP) {
            listCTSP.add(new ChiTietSanPhamViewModel(i, S.getId(), S.getSanPham().getMa(), S.getSanPham().getTen(), S.getNamBH(), S.getMoTa(), S.getSlTon(), S.getGiaNhap(), S.getGiaBan()));
            i++;
        }

        return listCTSP;

    }

    @Override
    public List<ChiTietSanPhamViewModel> search(String keyWord) {
        List<SanPhamViewModel> listSP = chiTietSanPhamRepository.search(keyWord);
        List<ChiTietSanPhamViewModel> listCTSP = new ArrayList<>();
        int i = 1;
        for (SanPhamViewModel sp : listSP) {
            listCTSP.add(new ChiTietSanPhamViewModel(i, sp.getId(), sp.getSanPham().getMa(), sp.getSanPham().getTen(), sp.getNamBH(), sp.getMoTa(), sp.getSlTon(), sp.getGiaNhap(), sp.getGiaBan()));
            i++;
        }
        return listCTSP;
    }

    @Override
    public SanPhamViewModel getCTSPByid(String idctSP) {
        return chiTietSanPhamRepository.getCTSPByid(idctSP);
    }

}
