package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.NguoiDap;
import vn.codegym.repository.NguoiDapRepository;

import java.util.List;
@Service
public class NguoiDapSerivceImpl implements NguoiDapService {
    @Autowired
    NguoiDapRepository nguoiDapRepository;
    @Override
    public List<NguoiDap> findAll() {
        return nguoiDapRepository.findAll();
    }
}
