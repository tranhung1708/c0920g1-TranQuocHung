package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.CauHoi;

import java.util.List;

public interface CauHoiService {

    Page<CauHoi> findAll(Pageable pageable);
    List<CauHoi> findAll();
    void save(CauHoi cauHoi);
    void delete(int id);
    CauHoi findById(int id);
    List<CauHoi> search(String tieuDe , String loaiCauHoi);
}
