package dev.ebank.account.web;

import dev.ebank.account.model.dtos.AccountDto;
import dev.ebank.account.model.entities.Account;
import dev.ebank.account.service.AccountService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;
    private static final Logger loggerInfo = LoggerFactory.getLogger(Account.class);


    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        loggerInfo.info("Account logging info is enabled");
        loggerInfo.debug("Account logging debug is enabled");
        List<AccountDto> accounts = new ArrayList<>();
        accounts = accountService.allAccounts();
        return ResponseEntity.ok(accounts);

    }
    @GetMapping("/accounts/{id}")
    public  ResponseEntity<AccountDto> getAccount(@PathVariable String id){
    return ResponseEntity.ok(accountService.getAccount(id));
    }
    @PostMapping("/create/{id}")
    public  ResponseEntity<String> createAccount(@Valid @RequestBody AccountDto accountDto){
        return  ResponseEntity.ok(accountService.newAccount(accountDto));
    }
    @PutMapping("/update")
    public  ResponseEntity<Boolean> updateAccount(@Valid @RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.updateAccount(accountDto));
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Boolean> deleteAccount(@PathVariable String id){
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName= ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return errors;
    }
}
