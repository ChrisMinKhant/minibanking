package com.intern.rest.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewCustomerRequest {

    private String name;
    private String nrc;
    private Date dateOfBirth;
    private String fatherName;
    private String mobileNumber;
    private String username;
    private String password;
}
