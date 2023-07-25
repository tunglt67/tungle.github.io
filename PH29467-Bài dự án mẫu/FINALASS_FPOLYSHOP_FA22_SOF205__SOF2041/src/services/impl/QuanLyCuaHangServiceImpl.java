/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.CuaHang;
import java.util.List;
import repositories.CuaHangRepository;
import services.IQuanLyCuaHangService;

/**
 *
 * @author Bânbân
 */
public class QuanLyCuaHangServiceImpl implements IQuanLyCuaHangService {

    CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAllCuaHang() {
        return cuaHangRepository.getAll();
    }

    @Override
    public String save(CuaHang ch) {
        boolean addCH = cuaHangRepository.insertCH(ch);
        if (addCH) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }

    @Override
    public String update(String ma, CuaHang ch, int index) {
        boolean updateCH = cuaHangRepository.update(ma, ch);
        if (updateCH) {
            return "Cập nhật thành công!";
        }
        return "Cập nhật thất bại!";
    }

    @Override
    public String delete(String ma) {
        boolean deleteCH = cuaHangRepository.delete(ma);
        if (deleteCH) {
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }

    

}
