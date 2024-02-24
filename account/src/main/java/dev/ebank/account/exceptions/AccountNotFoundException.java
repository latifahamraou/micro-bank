package dev.ebank.account.exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message){

        super("code: 102- " +message);
    }
}
