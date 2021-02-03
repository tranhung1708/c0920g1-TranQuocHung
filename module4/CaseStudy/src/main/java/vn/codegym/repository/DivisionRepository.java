package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.Model.Division;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
