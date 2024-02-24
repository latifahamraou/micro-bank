package dev.ebank.account.exceptions;

public class AccountBlockedException extends RuntimeException{
    public AccountBlockedException(String message){

        super("code: 103-" +message);
    }
}
