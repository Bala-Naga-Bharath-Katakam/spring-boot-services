package com.easycoding.accounts.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountsDAO {

    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
