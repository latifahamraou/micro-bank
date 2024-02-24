package dev.ebank.contact.exceptions;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String message){

        super("code: 102- " +message);
    }
}
