package dev.ebank.account.exceptions;

public class AccountAlreadyExistsException extends RuntimeException{
    public AccountAlreadyExistsException(String message){
        super("code: 101-" +message);
    }
}
