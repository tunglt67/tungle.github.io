/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.ChucVu;
import java.util.List;
import repositories.ChucVuRepository;
import services.IQuanLyChucVuService;

/**
 *
 * @author Bânbân
 */
public class QuanLyChucVuServiceImpl implements IQuanLyChucVuService {

    ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public List<ChucVu> getAllChucVu() {
        return chucVuRepository.getAll();
    }

    @Override
    public String save(ChucVu cv) {
        boolean addCV = chucVuRepository.insertCV(cv);
        if (addCV) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }

    @Override
    public String update(String ma, ChucVu cv, int index) {
        boolean updateCV = chucVuRepository.update(ma, cv);
        if (updateCV) {
            return "Cập nhật thành công!";
        }
        return "Cập nhật thất bại!";
    }

    @Override
    public String delete(String ma) {
        boolean deleteCV = chucVuRepository.delete(ma);
        if (deleteCV) {
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }

}
