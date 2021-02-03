package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.Model.Contract;
import vn.codegym.Model.Customer;

public interface ContractRepository extends JpaRepository<Contract , String> {
    Page<Contract> findAllByContractIdContaining(Pageable pageable, String nameSearch);
}
