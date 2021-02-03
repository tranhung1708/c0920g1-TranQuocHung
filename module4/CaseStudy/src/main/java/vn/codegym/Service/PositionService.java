package vn.codegym.Service;

import vn.codegym.Model.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();

    void save(Position position);

    void update(Position position);

    void delete(int id);

}
