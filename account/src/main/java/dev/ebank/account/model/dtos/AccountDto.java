package dev.ebank.account.model.dtos;

import dev.ebank.account.enums.AccountStatus;
import dev.ebank.account.model.classes.Customer;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private  String id;
    private LocalDate createAt;
    private double balance;
    private String currency;
    private AccountStatus status;
    private Customer customer;

}
