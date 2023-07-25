/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.DongSanPham;
import java.util.List;
import repositories.DongSPRepository;
import services.IQuanLyDongSPService;

/**
 *
 * @author Bânbân
 */
public class QuanLyDongSPServiceImpl implements IQuanLyDongSPService {

    DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    public List<DongSanPham> getAllDongSP() {
        return dongSPRepository.getAll();
    }

    @Override
    public String save(DongSanPham dsp) {
        boolean addDSP = dongSPRepository.insertDSP(dsp);
        if (addDSP) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }

    @Override
    public String update(String ma, DongSanPham dsp, int index) {
        boolean updateDSP = dongSPRepository.update(ma, dsp);
        if (updateDSP) {
            return "Cập nhật thành công!";
        }
        return "Cập nhật thất bại!";
    }

    @Override
    public String delete(String ma) {
        boolean deleteDSP = dongSPRepository.delete(ma);
        if (deleteDSP) {
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }

}
