package com.intern.rest.entity;

import com.intern.rest.constant.ProductType;
import com.intern.rest.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "accounts")
public class Account {
    @Id
    private String accountNumber;
    private ProductType type;
    private Date openingDate;
    private Status status;
    private Double balance;
}
