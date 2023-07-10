package com.intern.rest.model.account;

import com.intern.rest.constant.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAccountRequest {
    private ProductType type;
    private Double balance;
}
