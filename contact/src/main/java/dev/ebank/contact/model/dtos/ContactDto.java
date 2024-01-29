package dev.ebank.contact.model.dtos;

import dev.ebank.contact.model.classes.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String iban;

}
