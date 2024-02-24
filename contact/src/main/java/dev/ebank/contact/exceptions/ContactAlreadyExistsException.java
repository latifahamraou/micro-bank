package dev.ebank.contact.exceptions;

public class ContactAlreadyExistsException extends RuntimeException{
    public ContactAlreadyExistsException(String message){
        super("code: 110-" +message);
    }
}
