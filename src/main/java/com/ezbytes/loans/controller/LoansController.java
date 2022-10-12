package com.ezbytes.loans.controller;

import com.ezbytes.loans.entity.CustomerEntity;
import com.ezbytes.loans.entity.LoansEntity;
import com.ezbytes.loans.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @PostMapping("/myLoans")
    public List<LoansEntity> getLoansDetails(@RequestBody CustomerEntity customer) {
        List<LoansEntity> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (loans != null) {
            return loans;
        }

        return null;
    }

}
