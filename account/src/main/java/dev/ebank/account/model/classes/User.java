package dev.ebank.account.model.classes;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class User {
    private Long id;
    private String firstname;
    private String lastname;
   // private String password;
    private String email;
    private boolean active;

}
