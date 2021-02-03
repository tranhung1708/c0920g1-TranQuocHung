package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.GiaoDich;
import vn.codegym.repository.GiaoDichRepository;

import java.util.List;
@Service
public class GiaoDichServiceImpl implements GiaoDichService {
    @Autowired
    GiaoDichRepository giaoDichRepository;
    @Override
    public List<GiaoDich> findAll() {
        return giaoDichRepository.findAll();
    }

    @Override
    public Page<GiaoDich> findAll(Pageable pageable) {
        return giaoDichRepository.findAll(pageable);
    }

    @Override
    public void save(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    @Override
    public GiaoDich findById(String id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        giaoDichRepository.deleteById(id);
    }

    @Override
    public List<GiaoDich> search( String tenGiaoDich, String tenKhachHang) {
        return giaoDichRepository.search( tenGiaoDich , tenKhachHang);
    }


//    @Override
//    public List<GiaoDich> findAllByTenGiaoDichContainingAndKhachHang_TenKhachHang(String tenGiaoDich, String tenKhachHang) {
//        return giaoDichRepository.findAllByTenGiaoDichContainingAndKhachHang_TenKhachHang(tenGiaoDich,tenKhachHang);
//    }
}
