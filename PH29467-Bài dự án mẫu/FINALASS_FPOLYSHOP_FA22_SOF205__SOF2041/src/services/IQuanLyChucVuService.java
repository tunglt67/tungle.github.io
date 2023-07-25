/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.ChucVu;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyChucVuService {

    List<ChucVu> getAllChucVu();

    String save(ChucVu cv);

    String update(String ma, ChucVu cv, int index);

    String delete(String ma);
}
