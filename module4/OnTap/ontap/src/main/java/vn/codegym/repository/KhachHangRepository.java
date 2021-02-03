package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.KhachHang;

public interface KhachHangRepository  extends JpaRepository<KhachHang , String> {
}
