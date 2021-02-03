package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.NguoiHoi;
@Repository
public interface NguoiHoiRepository extends JpaRepository<NguoiHoi , Integer> {
}
