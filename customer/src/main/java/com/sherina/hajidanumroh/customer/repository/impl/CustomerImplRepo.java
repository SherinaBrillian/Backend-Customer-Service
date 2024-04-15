package com.sherina.hajidanumroh.customer.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.sherina.hajidanumroh.customer.constants.Constant;
import com.sherina.hajidanumroh.customer.dto.CustomerResponseModel;
import com.sherina.hajidanumroh.customer.dto.request.CustomerRequest;
import com.sherina.hajidanumroh.customer.repository.CustomerRepo;

@Service
public class CustomerImplRepo implements CustomerRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveData(CustomerRequest customerModel) {
        UUID customerUid = UUID.randomUUID();
        customerModel.setCustomerUid(customerUid.toString().replace("-", ""));
        Object[] queryParam = new Object[] {customerModel.getCustomerUid(), customerModel.getUserUid(), customerModel.getAddress(), customerModel.getPihkKbihu(), customerModel.getNotes(), customerModel.getVerifiedBy(), customerModel.getVerifiedAt(), customerModel.getUserImage(), customerModel.getVerifyImage(), customerModel.getDirImage(), customerModel.getCreatedBy()};
        jdbcTemplate.update(Constant.Customer.INSERT_DATA, queryParam);
    }

    @Override
    public void updateData(CustomerRequest customerModel) {
        Object[] queryParam = new Object[] {customerModel.getUserUid(), customerModel.getAddress(), customerModel.getPihkKbihu(), customerModel.getNotes(), customerModel.getVerifiedBy(), customerModel.getVerifiedAt(), customerModel.getUserImage(), customerModel.getVerifyImage(), customerModel.getDirImage(), customerModel.getCreatedBy(), customerModel.getCustomerUid()};
        jdbcTemplate.update(Constant.Customer.UPDATE_BY_ID, queryParam);
    }

    @Override
    public void deleteData(String customerUid) {
        Object[] queryParam = new Object[] {customerUid};
        jdbcTemplate.update(Constant.Customer.DELETE_BY_ID, queryParam);
    }

    @Override
    public List<CustomerResponseModel> getAll() {
        List<CustomerResponseModel> data = jdbcTemplate.query(Constant.Customer.GET_ALL, new CustomerListExtractor());
        return data;
    }

    @Override
    public CustomerResponseModel getById(String customerUid) {
        Object[] queryParam = new Object[] {customerUid};
        CustomerResponseModel data = jdbcTemplate.query(Constant.Customer.GET_BY_ID, new CustomerExtractor(), queryParam);
        return data;
    }

    //Extractor
    public static final class CustomerListExtractor implements ResultSetExtractor<List<CustomerResponseModel>> {
        @Override
        public List<CustomerResponseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<CustomerResponseModel> data = new ArrayList<>();
            while (rs.next()) {
                CustomerResponseModel customerModel = new CustomerResponseModel();
                customerModel.setCustomerUid(rs.getString("customerUid"));
                customerModel.setUserUid(rs.getString("userUid"));
                customerModel.setAddress(rs.getString("address"));
                customerModel.setPihkKbihu(rs.getString("pihkKbihu"));
                customerModel.setNotes(rs.getString("notes"));
                customerModel.setVerifiedBy(rs.getString("verifiedBy"));
                customerModel.setVerifiedAt(rs.getString("verifiedAt"));
                customerModel.setUserImage(rs.getString("userImage"));
                customerModel.setVerifyImage(rs.getString("verifyImage"));
                customerModel.setDirImage(rs.getString("dirImage"));
                customerModel.setCreatedBy(rs.getString("createdBy"));
                data.add(customerModel);
            }
            return data;
            
        }
    }

    public static final class CustomerExtractor implements ResultSetExtractor<CustomerResponseModel> {
        @Override
        public CustomerResponseModel extractData(ResultSet rs) throws SQLException, DataAccessException {
            CustomerResponseModel customerModel = new CustomerResponseModel();
            if(rs.next()){
                customerModel.setCustomerUid(rs.getString("customerUid"));
                customerModel.setUserUid(rs.getString("userUid"));
                customerModel.setAddress(rs.getString("address"));
                customerModel.setPihkKbihu(rs.getString("pihkKbihu"));
                customerModel.setNotes(rs.getString("notes"));
                customerModel.setVerifiedBy(rs.getString("verifiedBy"));
                customerModel.setVerifiedAt(rs.getString("verifiedAt"));
                customerModel.setUserImage(rs.getString("userImage"));
                customerModel.setVerifyImage(rs.getString("verifyImage"));
                customerModel.setDirImage(rs.getString("dirImage"));
                customerModel.setCreatedBy(rs.getString("createdBy"));

                return customerModel;
            }
            else{
                customerModel = null;
                return customerModel;
            }
            
        }
    }
    
}
    

