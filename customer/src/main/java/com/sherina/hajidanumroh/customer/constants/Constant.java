package com.sherina.hajidanumroh.customer.constants;

public class Constant {
    public static final class Customer {
        public static final String INSERT_DATA = "INSERT into tbCustomer (customerUid, userUid, address, pihkKbihu, notes, verifiedBy,verifiedAt, userImage, verifyImage, dirImage, createdBy) value (?,?,?,?,?,?,?,?,?,?,?)";
        public static final String UPDATE_BY_ID = "UPDATE tbCustomer set userUid = ?, address = ?, pihkKbihu = ?, notes = ?, verifiedBy = ?, verifiedAt = ?, userImage = ?, verifyImage = ?, dirImage = ?, createdBy = ? where customerUid = ?";
        public static final String DELETE_BY_ID = "DELETE from tbCustomer where customerUid = ?";
        public static final String GET_ALL = "Select * from tbCustomer";
        public static final String GET_BY_ID = "Select * from tbCustomer where customerUid = ?";
}

}
