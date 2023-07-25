/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.MauSac;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IQuanLyMauSacService {

    List<MauSac> getAllMauSac();

    String save(MauSac ms);

    String update(String ma, MauSac ms, int index);

    String delete(String ma);
}
