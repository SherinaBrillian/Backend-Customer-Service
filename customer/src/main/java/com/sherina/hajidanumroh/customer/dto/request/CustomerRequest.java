package com.sherina.hajidanumroh.customer.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String customerUid;
    private String userUid;
    private String address;
    private String pihkKbihu;
    private String notes;
    private String verifiedBy;
    private String verifiedAt;
    private String userImage;
    private String verifyImage;
    private String dirImage;
    private String createdBy;
}
