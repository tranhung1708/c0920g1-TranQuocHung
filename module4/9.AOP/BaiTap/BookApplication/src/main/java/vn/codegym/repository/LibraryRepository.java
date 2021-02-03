package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Library;

public interface LibraryRepository extends JpaRepository<Library , Integer> {
}
