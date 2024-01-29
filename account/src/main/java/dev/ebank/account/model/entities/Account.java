package dev.ebank.account.model.entities;

import dev.ebank.account.enums.AccountStatus;
import dev.ebank.account.model.classes.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Builder
@Table(name = "_account")
public class Account {

    @Id
    private  String id;
    private LocalDate createAt;
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @Transient
    private Customer customer;
    private Long customerId;

}
