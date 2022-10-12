package com.ezbytes.loans.repository;

import com.ezbytes.loans.entity.LoansEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoansRepository extends JpaRepository<LoansEntity, Long> {

    List<LoansEntity> findByCustomerIdOrderByStartDtDesc(int customerId);


}
