package dev.ebank.contact;

import dev.ebank.contact.clients.UserCLientRest;
import dev.ebank.contact.model.entity.Contact;
import dev.ebank.contact.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class ContactApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContactRepository contactRepository, UserCLientRest userCLientRest) {
        return args -> {
            userCLientRest.allUsers().forEach(user -> {
                var contacts = List.of(
                        Contact.builder()
                                .id(1L)
                                .firstname("Daniel")
                                .lastname("Nguessan")
                                .email("daniel@gmail.com")
                                .idUser(user.getId())
                                .iban(UUID.randomUUID().toString())
                                .build(),
                        Contact.builder()
                                .id(1L)
                                .firstname("Daniel")
                                .lastname("Nguessan")
                                .email("daniel@gmail.com")
                                .idUser(user.getId())
                                .iban(UUID.randomUUID().toString())
                                .build());

                contactRepository.saveAll(contacts);
            }

        );

        };
        }
    }
