package com.jumia.phonevalidation.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jumia.phonevalidation.io.entity.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
