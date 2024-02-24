package dev.ebank.account.model.dtos;

import dev.ebank.account.enums.AccountStatus;
import dev.ebank.account.model.classes.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AccountDto {
    @Valid

    private  String iban;
    @NotNull(message="createAt is mandatory")
    @NotBlank(message = "createAt is mandatory")
    private LocalDate createAt;
    @NotBlank(message = "balance is mandatory")
    private double balance;
    @NotNull(message="currency is mandatory")
    @NotBlank(message = "currency is mandatory")
    private String currency;
    @NotNull(message="accountStatus is mandatory")
    @NotBlank(message = "accountStatus is mandatory")
    private AccountStatus status;
    @NotNull(message = "UserId is mandatory")
    private Long userId;
    @NotBlank(message = "user is mandatory")
    @NotNull(message = "user is mandatory")
    private User user;

}
