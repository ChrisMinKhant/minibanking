package com.intern.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;

    private String name;
    private String nrc;
    private Date dateOfBirth;
    private String fatherName;
    private String mobileNumber;
    private String userName;
    private String password;
}
