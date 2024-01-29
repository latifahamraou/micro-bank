package dev.ebank.account.service.mapper;

import dev.ebank.account.model.dtos.AccountDto;
import dev.ebank.account.model.entities.Account;

public interface AccountMapper {
    Account toEntity(AccountDto accountDto);
    AccountDto toDto(Account account );
    void copy(AccountDto accountDto, Account account);
}
