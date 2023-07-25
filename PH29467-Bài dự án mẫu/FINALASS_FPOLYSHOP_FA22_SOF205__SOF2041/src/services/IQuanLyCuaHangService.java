/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.CuaHang;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyCuaHangService {

    List<CuaHang> getAllCuaHang();

    String save(CuaHang ch);

    String update(String ma, CuaHang ch,int index);

    String delete(String ma);
}
