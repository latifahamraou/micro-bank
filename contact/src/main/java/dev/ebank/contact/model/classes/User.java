package dev.ebank.contact.model.classes;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Integer id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private boolean active;

}
