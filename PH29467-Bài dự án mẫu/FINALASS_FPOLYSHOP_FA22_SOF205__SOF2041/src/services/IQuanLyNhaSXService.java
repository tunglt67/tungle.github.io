/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.NhaSX;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyNhaSXService {

    List<NhaSX> getAllNhaSX();

    String save(NhaSX nsx);

    String update(String ma, NhaSX nsx, int index);

    String delete(String ma);
}
