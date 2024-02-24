package dev.ebank.account.service;

import dev.ebank.account.clients.UserClientRest;
import dev.ebank.account.exceptions.AccountNotFoundException;
import dev.ebank.account.model.classes.User;
import dev.ebank.account.model.dtos.AccountDto;
import dev.ebank.account.model.entities.Account;
import dev.ebank.account.repository.AccountRepository;
import dev.ebank.account.service.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserClientRest userCLientRest;


    public List<AccountDto> allAccounts(){
        List<Account> accounts = accountRepository.findAll();
        accounts.forEach(acc ->{
            acc.setUser(userCLientRest.findUserById(acc.getUserId()));
                });
        return accounts.stream().map(accountMapper::toDto).collect(Collectors.toList());
    }
    public AccountDto getAccount(String iban){
        Account acc =   accountRepository.findById(iban).get();

        User user= userCLientRest.findUserById(acc.getUserId());
        acc.setUser(user);
        return accountMapper.toDto(acc);

    }
    public Boolean deleteAccount(String iban) {
        Account account =  accountRepository.findById(iban)
                .orElseThrow(() -> new AccountNotFoundException("account not found"));
        accountRepository.deleteById(account.getIban());
        return true;
    }
    public Boolean updateAccount(AccountDto accountDto) {
        Account account =  accountRepository.findById(accountDto.getIban())
                .orElseThrow(() -> new AccountNotFoundException("account not found"));
        accountMapper.copy(accountDto, account);
        accountRepository.save(account);
        return true;
    }
    public String  newAccount(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);

        User user = userCLientRest.findUserById(account.getUserId());
        account.setUser(user);
        return accountRepository.save(account).getIban();

    }

}
