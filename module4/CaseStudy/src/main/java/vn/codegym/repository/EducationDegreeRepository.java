package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.Model.Education_degree;

public interface EducationDegreeRepository extends JpaRepository<Education_degree,Integer> {
}
