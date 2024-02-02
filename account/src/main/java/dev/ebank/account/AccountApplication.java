package dev.ebank.account;

import dev.ebank.account.clients.UserClientRest;
import dev.ebank.account.enums.AccountStatus;
import dev.ebank.account.model.entities.Account;
import dev.ebank.account.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, UserClientRest userCLientRest) {
        return args -> {
          userCLientRest.allUsers().forEach(user -> {

                       Account bankAccount1 = Account.builder()
                               .id(UUID.randomUUID().toString())
                               .currency("MAD")
                               .balance(Math.random() * 80000)
                               .createAt(LocalDate.now())
                               .status(AccountStatus.ACTIVATED)
                               .userId(user.getId())
                               .build();

                       Account bankAccount2 = Account.builder()
                               .id(UUID.randomUUID().toString())
                               .currency("MAD")
                               .balance(Math.random() * 65432)
                               .createAt(LocalDate.now())
                               .status(AccountStatus.ACTIVATED)
                               .userId(user.getId())
                             //  .user(user)
                               .build();
                       accountRepository.save(bankAccount1);
                       accountRepository.save(bankAccount2);
                 }

                 );
        };
    }
}
