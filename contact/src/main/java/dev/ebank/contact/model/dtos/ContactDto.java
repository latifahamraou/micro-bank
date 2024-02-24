package dev.ebank.contact.model.dtos;

import dev.ebank.contact.model.classes.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {
    @Valid

    //@NotNull(message = "id is mandatory")
    private Long id;
    @NotNull(message = "firstname is mandatory")
    @NotBlank(message = "firstname is mandatory")
    @Size(min = 4, max = 20)
    private String firstname;
    @NotNull(message = "lastname is mandatory")
    @NotBlank(message = "lastname is mandatory")
    @Size(min = 4, max = 20)
    private String lastname;
    @NotNull(message = "email is mandatory")
    @NotBlank(message = "email is mandatory")
    @Size(min = 8, max = 20)
    private String email;
    @NotNull(message = "iban is mandatory")
    @NotBlank(message = "iban is mandatory")
    private String iban;

}
