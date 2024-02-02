package dev.ebank.account.web;

import dev.ebank.account.model.dtos.AccountDto;
import dev.ebank.account.model.entities.Account;
import dev.ebank.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;


    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = new ArrayList<>();
        accounts = accountService.allAccounts();
        return ResponseEntity.ok(accounts);

    }
    @GetMapping("/accounts/{id}")
    public  ResponseEntity<AccountDto> getAccount(@PathVariable String id){
    return ResponseEntity.ok(accountService.getAccount(id));
    }
    @PostMapping("/create/{id}")
    public  ResponseEntity<String> createAccount(@RequestBody AccountDto accountDto){
        return  ResponseEntity.ok(accountService.newAccount(accountDto));
    }
    @PutMapping("/update")
    public  ResponseEntity<Boolean> updateAccount(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.updateAccount(accountDto));
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Boolean> deleteAccount(@PathVariable String id){
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }
}
