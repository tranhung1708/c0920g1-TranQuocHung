package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.model.CauHoi;

import java.util.List;

@Repository
public interface CauHoiRepoSitry  extends JpaRepository<CauHoi , Integer> {
    @Query("select c from cauHoi c where c.tieuDe like %?1% and c.loaiCauHoi like %?2%")
    List<CauHoi> search(String tieuDe, String loaiCauHoi);
}
