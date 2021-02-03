package vn.codegym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.Model.Education_degree;
import vn.codegym.Service.EducationDegreeService;
import vn.codegym.repository.EducationDegreeRepository;

import java.util.List;
@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<Education_degree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
