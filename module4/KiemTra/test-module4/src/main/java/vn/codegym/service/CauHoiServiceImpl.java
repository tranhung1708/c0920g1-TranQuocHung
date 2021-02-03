package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.CauHoi;
import vn.codegym.repository.CauHoiRepoSitry;

import java.util.List;

@Service
public class CauHoiServiceImpl implements CauHoiService {
    @Autowired
    CauHoiRepoSitry cauHoiRepoSitry;

    @Override
    public Page<CauHoi> findAll(Pageable pageable) {
        return cauHoiRepoSitry.findAll(pageable);
    }

    @Override
    public List<CauHoi> findAll() {
        return cauHoiRepoSitry.findAll();
    }

    @Override
    public void save(CauHoi cauHoi) {
        cauHoiRepoSitry.save(cauHoi);
    }

    @Override
    public void delete(int id) {
        cauHoiRepoSitry.deleteById(id);
    }

    @Override
    public CauHoi findById(int id) {
        return cauHoiRepoSitry.findById(id).orElse(null);
    }

    @Override
    public List<CauHoi> search(String tieuDe, String loaiCauHoi) {
        return cauHoiRepoSitry.search(tieuDe, loaiCauHoi);
    }
}
