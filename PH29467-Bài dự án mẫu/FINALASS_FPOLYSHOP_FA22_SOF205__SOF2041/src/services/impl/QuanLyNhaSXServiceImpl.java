/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.NhaSX;
import java.util.List;
import repositories.NhaSXRepository;
import services.IQuanLyNhaSXService;

/**
 *
 * @author Bânbân
 */
public class QuanLyNhaSXServiceImpl implements IQuanLyNhaSXService {

    NhaSXRepository nhaSXRepository = new NhaSXRepository();

    @Override
    public List<NhaSX> getAllNhaSX() {
        return nhaSXRepository.getAll();
    }

    @Override
    public String save(NhaSX nsx) {
        boolean addNSX = nhaSXRepository.insertNSX(nsx);
        if (addNSX) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }

    @Override
    public String update(String ma, NhaSX nsx, int index) {
        boolean updateNSX = nhaSXRepository.update(ma, nsx);
        if (updateNSX) {
            return "Cập nhật thành công!";
        }
        return "Cập nhật thất bại!";
    }

    @Override
    public String delete(String ma) {
        boolean deleteNSX = nhaSXRepository.delete(ma);
        if (deleteNSX) {
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }

}
