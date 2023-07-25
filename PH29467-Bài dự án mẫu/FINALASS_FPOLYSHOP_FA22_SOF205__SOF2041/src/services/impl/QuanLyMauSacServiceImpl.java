/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.MauSac;
import java.util.List;
import repositories.MauSacRepository;
import services.IQuanLyMauSacService;

/**
 *
 * @author Bânbân
 */
public class QuanLyMauSacServiceImpl implements IQuanLyMauSacService {

    MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAllMauSac() {
        return mauSacRepository.getAll();
    }

    @Override
    public String save(MauSac ms) {
        boolean addMS = mauSacRepository.insertCV(ms);
        if (addMS) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }

    @Override
    public String update(String ma, MauSac ms, int index) {
        boolean updateMS = mauSacRepository.update(ma, ms);
        if (updateMS) {
            return "Cập nhật thành công!";
        }
        return "Cập nhật thất bại!";
    }

    @Override
    public String delete(String ma) {
        boolean deleteMS = mauSacRepository.delete(ma);
        if (deleteMS) {
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }

}
