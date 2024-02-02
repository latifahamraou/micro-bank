package dev.ebank.account.model.entities;

import dev.ebank.account.enums.AccountStatus;
import dev.ebank.account.model.classes.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
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
    private User user;
    private Long userId;

}
