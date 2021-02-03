package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.KhachHang;
import vn.codegym.repository.KhachHangRepository;

import java.util.List;
@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;
    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }
}
