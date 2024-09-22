package com.easycoding.accounts.dao;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDAO {

    private String name;

    private String email;

    private Long mobileNumber;
}
