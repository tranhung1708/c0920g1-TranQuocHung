package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.repository.CustomerRepository;
import cg.wbd.grandemonstration.service.CustomerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomerServiceImplWithSpringData implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return streamAll().collect(Collectors.toList());
    }

    @Override
    public Page<Customer> findAll(Pageable pageInfo) throws Exception {
        return customerRepository.findAll(pageInfo);
    }

    @Override
    public List<Customer> search(String keyword) {
        Iterable<Customer> searchResult = customerRepository
                .findAllByNameContainsOrEmailContainsOrAddressContains(keyword, keyword, keyword);
        return streamAll(searchResult).collect(Collectors.toList());
    }

    @Override
    public Page<Customer> search(String keyword, Pageable pageInfo) {
        return customerRepository
                .findAllByNameContainsOrEmailContainsOrAddressContains(keyword, keyword, keyword, pageInfo);
    }

    @Override
    public Customer findOne(Long id) throws Exception {
        Customer target = customerRepository.findOne(id);
        if (target == null) {
            throw new Exception("customer not found!");
        }
        return target;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        Iterable<Customer> updatedCustomers = customerRepository.save(customers);
        return streamAll(updatedCustomers).collect(Collectors.toList());
    }

    @Override
    public boolean exists(Long id) {
        return customerRepository.exists(id);
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        Iterable<Customer> customers = customerRepository.findAll(ids);
        return streamAll(customers).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        customerRepository.delete(customers);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    private Stream<Customer> streamAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false);
    }

    private Stream<Customer> streamAll(Iterable<Customer> customers) {
        return StreamSupport.stream(customers.spliterator(), false);
    }
    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.*.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
