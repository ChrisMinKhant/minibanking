package com.intern.rest.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private String id;
    private String name;
    private String nrc;
    private Date dateOfBirth;
    private String fatherName;
    private String mobileNumber;
    private String username;
}
