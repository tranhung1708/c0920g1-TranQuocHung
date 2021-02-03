package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.Model.AttachService;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService , String> {
}
