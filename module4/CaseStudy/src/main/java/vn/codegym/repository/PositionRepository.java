package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.Model.Position;

public interface PositionRepository extends JpaRepository<Position,Integer> {
}
