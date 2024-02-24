package dev.ebank.account.service.mapper;

import dev.ebank.account.model.dtos.AccountDto;
import dev.ebank.account.model.entities.Account;
import org.springframework.stereotype.Component;
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toEntity(AccountDto accountDto) {
        if(accountDto == null) {
            return null;
        }
        Account.AccountBuilder account =Account.builder();

       /* if(accountDto.getIban() != null){
        account.iban(accountDto.getIban());
        }*/
        if(accountDto.getBalance() != 0){
            account.balance(accountDto.getBalance());

        }
        if(accountDto.getCurrency() != null){
            account.currency(accountDto.getCurrency());

        }
        if(accountDto.getCreateAt() != null){
            account.createAt(accountDto.getCreateAt());

        }
        if(accountDto.getUser() != null){
            account.user(accountDto.getUser());

        }
        if(accountDto.getUserId() != null){
            account.userId(accountDto.getUserId());

        }

    return account.build();
    }

    @Override
    public AccountDto toDto(Account account) {
        if(account == null){
            return null;
        }
        AccountDto.AccountDtoBuilder accountDto =AccountDto.builder();
        if(account.getIban() != null){
            accountDto.iban(account.getIban());
        }
        if(account.getBalance() != 0){
            accountDto.balance(account.getBalance());
        }
        if(account.getCurrency() != null){
            accountDto.currency(account.getCurrency());
        }
        if(account.getStatus() != null){
            accountDto.status(account.getStatus());
        }
        if(account.getCreateAt() != null){
            accountDto.createAt(account.getCreateAt());
        }
        if(account.getUser() != null){
            accountDto.user(account.getUser());
        }
        if(account.getUserId() != null){
            accountDto.userId(account.getUserId());
        }

        return accountDto.build();
    }

    @Override
    public void copy(AccountDto accountDto, Account account) {
        if(accountDto == null){
            return;
        }
        if(accountDto.getIban() != null){
            account.setIban(accountDto.getIban());
        }
        if(accountDto.getBalance() != 0){
            account.setBalance(accountDto.getBalance());
        }
        if(accountDto.getCurrency() != null){
            account.setCurrency(accountDto.getCurrency());
        }
        if(accountDto.getStatus() != null){
            account.setStatus(accountDto.getStatus());
        }
       /* if(accountDto.getCustomer() != null ){
            account.setCustomer(accountDto.getCustomer());
        }*/


    }
}



