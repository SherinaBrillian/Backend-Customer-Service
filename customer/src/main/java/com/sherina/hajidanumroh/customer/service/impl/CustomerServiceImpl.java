package com.sherina.hajidanumroh.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sherina.hajidanumroh.customer.dto.CustomerResponseModel;
import com.sherina.hajidanumroh.customer.dto.request.CustomerRequest;
import com.sherina.hajidanumroh.customer.dto.response.CustomerDataResponse;
import com.sherina.hajidanumroh.customer.dto.response.CustomerListResponse;
import com.sherina.hajidanumroh.customer.dto.response.WebResponseBase;
import com.sherina.hajidanumroh.customer.repository.impl.CustomerImplRepo;
import com.sherina.hajidanumroh.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
     @Autowired
    CustomerImplRepo customerRepo;

    @Override
    public WebResponseBase saveData(CustomerRequest customerModel) {
        try {
            WebResponseBase response = new WebResponseBase();
            customerRepo.saveData(customerModel);
            response.setStatus("OK");
            return response;
        } catch(DuplicateKeyException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Customer is already exist");
        }
    }

    @Override
    public WebResponseBase updateData(CustomerRequest customerModel) {
        WebResponseBase response = new WebResponseBase();
        customerRepo.updateData(customerModel);
        response.setStatus("OK");
        return response;
    }

    @Override
    public WebResponseBase deleteData(String customerUid) {
        WebResponseBase response = new WebResponseBase();
        customerRepo.deleteData(customerUid);
        response.setStatus("OK");
        return response;
    }

    @Override
    public CustomerListResponse getAll() {
        CustomerListResponse response = new CustomerListResponse();
        List<CustomerResponseModel> customerModel = customerRepo.getAll();
        response.setStatus("OK");
        response.setData(customerModel);
        return response;
    }

    @Override
    public CustomerDataResponse getById(String roomUid) {
        CustomerDataResponse response = new CustomerDataResponse();
        CustomerResponseModel customerModel = customerRepo.getById(roomUid);
        if(customerModel == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found!");
        }
        response.setStatus("OK");
        response.setData(customerModel);
        return response;
    }
}

