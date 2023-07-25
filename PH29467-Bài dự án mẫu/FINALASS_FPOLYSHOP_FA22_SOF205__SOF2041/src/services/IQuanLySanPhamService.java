/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.SanPham;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IQuanLySanPhamService {

    List<SanPham> getAllSanPhams();

    String save(SanPham sp);

    String update(String ma, SanPham sp, int index);

    String delete(String ma);

    SanPham getSPByMa(String ma);
}
