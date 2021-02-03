package vn.codegym.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.Model.ContractDetail;

public interface ContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    void save(ContractDetail contractDetail);

    void update(ContractDetail contractDetail);

    void delete(String id);

    ContractDetail findById(String id);

    Page<ContractDetail> findAllByContractDetailId(Pageable pageable, String nameSearch);

}
