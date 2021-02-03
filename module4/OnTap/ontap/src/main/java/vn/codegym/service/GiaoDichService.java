package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.GiaoDich;

import java.util.List;

public interface GiaoDichService {
    List<GiaoDich> findAll();
    Page<GiaoDich> findAll(Pageable pageable);
    void save(GiaoDich giaoDich);
    GiaoDich findById(String id);
    void delete(String id);
    List<GiaoDich> search( String tenGiaoDich , String tenKhachHang);
//    List<GiaoDich> findAllByTenGiaoDichContainingAndKhachHang_TenKhachHang(String tenGiaoDich, String tenKhachHang);

}
