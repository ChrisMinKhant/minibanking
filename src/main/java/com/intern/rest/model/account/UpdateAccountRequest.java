package com.intern.rest.model.account;

import com.intern.rest.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountRequest {
    private Status status;
    private Double balance;
}
