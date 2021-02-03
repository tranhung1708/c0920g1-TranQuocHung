package vn.codegym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.Model.Position;
import vn.codegym.Service.PositionService;
import vn.codegym.repository.PositionRepository;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void update(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void delete(int id) {
        positionRepository.deleteById(id);
    }

}
