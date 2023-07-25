/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.DongSanPham;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyDongSPService {

    List<DongSanPham> getAllDongSP();

    String save(DongSanPham dsp);

    String update(String ma, DongSanPham dsp, int index);

    String delete(String ma);
}
