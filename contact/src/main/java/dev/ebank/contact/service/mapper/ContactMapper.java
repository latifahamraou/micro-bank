package dev.ebank.contact.service.mapper;

import dev.ebank.contact.model.dtos.ContactDto;
import dev.ebank.contact.model.entity.Contact;

public interface ContactMapper {
    void copy(ContactDto contactDto, Contact contact);
    Contact toEntity(ContactDto contactDto);
    ContactDto toDto(Contact contact);
}
