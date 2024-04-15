package com.sherina.hajidanumroh.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherina.hajidanumroh.customer.dto.request.CustomerRequest;
import com.sherina.hajidanumroh.customer.dto.response.CustomerDataResponse;
import com.sherina.hajidanumroh.customer.dto.response.CustomerListResponse;
import com.sherina.hajidanumroh.customer.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.customer.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping("api/v1/Customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerRepo;

    @PostMapping
    public WebResponseBase saveData(@RequestBody CustomerRequest customerModel) {
        return customerRepo.saveData(customerModel);
    }

    @PutMapping
    @RequestMapping("/update/{customerUid}")
    public WebResponseBase updateData(@PathVariable String customerUid, @RequestBody CustomerRequest request) {
        request.setCustomerUid(customerUid);
        return customerRepo.updateData(request);  
    }

    @DeleteMapping
    @RequestMapping("/delete/{customerUid}")
    public WebResponseBase deleteData(@PathVariable String customerUid) {
        return customerRepo.deleteData(customerUid);
    }

    @GetMapping
    public CustomerListResponse getAll() {
        return customerRepo.getAll();
    }

    @GetMapping
    @RequestMapping("/{customerUid}")
    public CustomerDataResponse getById(@PathVariable String customerUid) {
        return customerRepo.getById(customerUid);
    }
}
