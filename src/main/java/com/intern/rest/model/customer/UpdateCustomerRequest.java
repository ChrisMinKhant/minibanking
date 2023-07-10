package com.intern.rest.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
    private String name;
    private String nrc;
    private Date dateOfBirth;
    private String fatherName;
    private String mobileNumber;
}
