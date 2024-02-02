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

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private boolean active;

}

