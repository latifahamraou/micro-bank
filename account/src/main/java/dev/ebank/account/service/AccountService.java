package dev.ebank.account.service;

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

    public List<AccountDto> allAccounts(){
    return accountRepository.findAll().stream().map(accountMapper::toDto).collect(Collectors.toList());
    }
    public AccountDto getAccount(String iban){
        return (AccountDto) accountRepository.findById(iban).map(accountMapper::toDto).get();
    }
    public Boolean deleteAccount(String iban) {
        Account account =  accountRepository.findById(iban).orElseThrow(() -> new RuntimeException("code 101: le "));
        accountRepository.deleteById(account.getId());
        return true;
    }
    public Boolean updateAccount(AccountDto accountDto) {
        Account account =  accountRepository.findById(accountDto.getId()).orElseThrow(() -> new RuntimeException("code 101: le "));
        accountMapper.copy(accountDto, account);
        accountRepository.save(account);
        return true;
    }
    public String  newAccount(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        return accountRepository.save(account).getId();

    }

}
