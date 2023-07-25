/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.NhanVien;
import java.util.List;
import repositories.NhanVienRepository;
import services.IQuanLyNhanVienService;

/**
 *
 * @author Bânbân
 */
public class QuanLyNhanVienServiceImpl1 implements IQuanLyNhanVienService {

    NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.getAll();
    }

    @Override
    public String save(NhanVien nv) {
        boolean addNV = nhanVienRepository.add(nv);
        if (addNV) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }

    @Override
    public String update(NhanVien nv, String id) {
        boolean updateNV = nhanVienRepository.update(nv, id);
        if (updateNV) {
            return "Cập nhật thành công!";
        }
        return "Cập nhật thất bại!";
    }

    @Override
    public String delete(String id) {
        boolean deleteNV = nhanVienRepository.delete(id);
        if (deleteNV) {
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }

    @Override
    public String getIDByCH(String ten) {
        return nhanVienRepository.getIDByCH(ten);
    }

    @Override
    public List<String> getListCH() {
        return nhanVienRepository.getListCH();
    }

    @Override
    public String getCHById(String id) {
        return nhanVienRepository.getCHByID(id);
    }

    @Override
    public String getIDByCV(String ten) {
        return nhanVienRepository.getIDByCV(ten);
    }

    @Override
    public List<String> getListCV() {
        return nhanVienRepository.getListCV();
    }

    @Override
    public String getCVById(String id) {
        return nhanVienRepository.getCVByID(id);
    }

    @Override
    public List<NhanVien> getAccount() {
        return nhanVienRepository.getAccount();
    }

}
