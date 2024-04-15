package com.sherina.hajidanumroh.customer.service;

import com.sherina.hajidanumroh.customer.dto.request.CustomerRequest;
import com.sherina.hajidanumroh.customer.dto.response.CustomerDataResponse;
import com.sherina.hajidanumroh.customer.dto.response.CustomerListResponse;
import com.sherina.hajidanumroh.customer.dto.response.WebResponseBase;

public interface CustomerService {
    WebResponseBase saveData(CustomerRequest customerModel);
    WebResponseBase updateData(CustomerRequest customerModel);
    WebResponseBase deleteData(String customerUid);
    CustomerListResponse getAll();
    CustomerDataResponse getById(String customerUid); 
}
