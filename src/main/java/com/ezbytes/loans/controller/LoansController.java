package com.ezbytes.loans.controller;

import com.ezbytes.loans.LoansServiceConfig;
import com.ezbytes.loans.entity.CustomerEntity;
import com.ezbytes.loans.entity.LoansEntity;
import com.ezbytes.loans.entity.Properties;
import com.ezbytes.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private LoansServiceConfig loansServiceConfig;

    @PostMapping("/myLoans")
    public List<LoansEntity> getLoansDetails(@RequestBody CustomerEntity customer) {
        List<LoansEntity> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (loans != null) {
            return loans;
        }

        return null;
    }

    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loansServiceConfig.getMsg(),
                loansServiceConfig.getBuildVersion(),
                loansServiceConfig.getMailDetails(),
                loansServiceConfig.getActiveBranches()
        );
        return ow.writeValueAsString(properties);
    }

}
