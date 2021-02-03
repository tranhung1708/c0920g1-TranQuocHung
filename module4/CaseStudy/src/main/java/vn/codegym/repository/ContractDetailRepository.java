package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.Model.Contract;
import vn.codegym.Model.ContractDetail;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, String> {
    Page<ContractDetail> findAllByContractDetailId(Pageable pageable, String nameSearch);
}
