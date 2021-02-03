package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.NguoiDap;
@Repository
public interface NguoiDapRepository  extends JpaRepository<NguoiDap , Integer> {
}
