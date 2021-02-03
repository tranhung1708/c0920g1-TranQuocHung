package vn.codegym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.Model.Contract;
import vn.codegym.Model.ContractDetail;
import vn.codegym.Service.ContractDetailService;
import vn.codegym.Service.ContractService;
import vn.codegym.repository.ContractDetailRepository;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
            contractDetailRepository.save(contractDetail);
    }

    @Override
    public void update(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(String id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public ContractDetail findById(String id) {
        return this.contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public Page<ContractDetail> findAllByContractDetailId(Pageable pageable, String nameSearch) {
        return this.contractDetailRepository.findAllByContractDetailId(pageable, nameSearch);
    }
}
