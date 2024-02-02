package dev.ebank.contact.service.mapper;

import dev.ebank.contact.model.dtos.ContactDto;
import dev.ebank.contact.model.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapperImpl implements ContactMapper{
    @Override
    public void copy(ContactDto contactDto, Contact contact) {
        if(contactDto == null){
            return;
        }

        if(contactDto.getIban() != null){
            contact.setIban(contactDto.getIban());
        }
        if(contactDto.getFirstname() != null){
            contact.setFirstname(contactDto.getFirstname());
        }
        if(contactDto.getLastname() != null){
            contact.setLastname(contactDto.getLastname());
        }
        if(contactDto.getEmail() != null){
            contact.setEmail(contactDto.getEmail());
        }

    }

    @Override
    public Contact toEntity(ContactDto contactDto) {
        if(contactDto == null){
            return null;
        }
        Contact.ContactBuilder  contact = Contact.builder();
        if(contactDto.getIban() != null){
            contact.iban(contactDto.getIban());
        }
        if(contactDto.getFirstname() != null){
            contact.firstname(contactDto.getFirstname());
        }
        if(contactDto.getLastname() != null){
            contact.lastname(contactDto.getLastname());
        }
        if(contactDto.getEmail() != null){
            contact.email(contactDto.getEmail());
        }
        return contact.build();
    }

    @Override
    public ContactDto toDto(Contact contact) {
        if(contact == null){
            return null;
        }
        ContactDto.ContactDtoBuilder  contactDto = ContactDto.builder();

        if(contact.getId() != null){
            contactDto.id(contact.getId());
        }
        if(contact.getIban() != null){
            contactDto.iban(contact.getIban());
        }
        if(contact.getFirstname() != null){
            contactDto.firstname(contact.getFirstname());
        }
        if(contact.getLastname() != null){
            contactDto.lastname(contact.getLastname());
        }
        if(contact.getEmail() != null){
            contactDto.email(contact.getEmail());
        }

        return contactDto.build();
    }
}
