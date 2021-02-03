package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.NguoiHoi;
import vn.codegym.repository.NguoiHoiRepository;

import java.util.List;

@Service
public class NguoiHoiSerivceImpl  implements NguoiHoiService{
    @Autowired
    NguoiHoiRepository nguoiHoiRepository;

    @Override
    public List<NguoiHoi> findAll() {
        return nguoiHoiRepository.findAll();
    }
}
