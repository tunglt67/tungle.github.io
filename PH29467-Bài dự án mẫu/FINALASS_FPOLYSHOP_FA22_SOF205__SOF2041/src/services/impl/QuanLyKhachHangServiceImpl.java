/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.KhachHang;
import java.util.List;
import repositories.KhachHangRepository;
import services.IQuanLyKhachHangService;

/**
 *
 * @author Bânbân
 */
public class QuanLyKhachHangServiceImpl implements IQuanLyKhachHangService {

    KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.getAll();
    }

    @Override
    public String save(KhachHang kh) {
        boolean addKH = khachHangRepository.insertKH(kh);
        if (addKH) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }

    @Override
    public String update(String ma, KhachHang kh, int index) {
        boolean updateKH = khachHangRepository.update(ma, kh);
        if (updateKH) {
            return "Cập nhật thành công!";
        }
        return "Cập nhật thất bại!";
    }

    @Override
    public String delete(String ma) {
        boolean deleteKH = khachHangRepository.delete(ma);
        if (deleteKH) {
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }

}
