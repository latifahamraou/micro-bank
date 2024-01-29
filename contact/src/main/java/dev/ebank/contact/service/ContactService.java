package dev.ebank.contact.service;

import dev.ebank.contact.model.dtos.ContactDto;
import dev.ebank.contact.model.entity.Contact;
import dev.ebank.contact.repository.ContactRepository;
import dev.ebank.contact.service.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactMapper contactMapper;

    public List<ContactDto> allUserContacts(Long id){
       return contactRepository.findContactByIdUser(id).stream().map(contactMapper::toDto).collect(Collectors.toList());
    }
    public ContactDto getContact(Long id){
          return contactMapper.toDto(contactRepository.findById(id).get());
    }
    public Boolean deleteContact(Long id){
        contactRepository.deleteById(id);
        return true;
    }
    public Boolean updateContact(Long id, ContactDto contactDto){
        Contact contact = contactRepository.findById(id).get();
        contactMapper.copy(contactDto, contact);
        contactRepository.save(contact);
        return true;
    }
    public Long createContact(ContactDto contactDto){
        return contactRepository.save(contactMapper.toEntity(contactDto)).getId();
    }
}
