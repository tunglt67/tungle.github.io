/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.SanPham;
import java.util.ArrayList;
import java.util.List;
import repositories.SanPhamRepository;
import services.IQuanLySanPhamService;
import viewmodels.ChiTietSanPhamViewModel;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author Bânbân
 */
public class QuanLySanPhamServiceImpl implements IQuanLySanPhamService {

    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getAllSanPhams() {
        return sanPhamRepository.getAll();
    }

    @Override
    public String save(SanPham sp) {
        boolean addSP = sanPhamRepository.insertSP(sp);
        if (addSP) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String delete(String ma) {
        boolean deleteSP = sanPhamRepository.delete(ma);
        if (deleteSP) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    @Override
    public String update(String ma, SanPham sp, int index) {
        boolean updateSP = sanPhamRepository.update(ma, sp);
        if (updateSP) {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }

   

    @Override
    public SanPham getSPByMa(String ma) {
        return sanPhamRepository.getSPByMa(ma);
    }

}
