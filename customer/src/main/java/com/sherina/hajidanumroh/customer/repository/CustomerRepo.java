package com.sherina.hajidanumroh.customer.repository;

import java.util.List;

import com.sherina.hajidanumroh.customer.dto.CustomerResponseModel;
import com.sherina.hajidanumroh.customer.dto.request.CustomerRequest;


public interface CustomerRepo {
    void saveData(CustomerRequest customerModel);
    void updateData(CustomerRequest customerModel);
    void deleteData(String customerUid);
    List<CustomerResponseModel>getAll();
    CustomerResponseModel getById(String customerUid);
}
