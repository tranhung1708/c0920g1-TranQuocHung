package vn.codegym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.Model.AttachService;
import vn.codegym.Service.AttachServiceService;
import vn.codegym.repository.AttachServiceRepository;

import java.util.List;
@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
