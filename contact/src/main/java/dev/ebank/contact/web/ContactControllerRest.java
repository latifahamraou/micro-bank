package dev.ebank.contact.web;

import dev.ebank.contact.model.dtos.ContactDto;
import dev.ebank.contact.model.entity.Contact;
import dev.ebank.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactControllerRest {
    @Autowired
    private ContactService contactService;

    @GetMapping("/{id}/contacts")
    public ResponseEntity<List<ContactDto>> getAllUserContacts(@PathVariable Long id){
       return ResponseEntity.ok(contactService.allUserContacts(id));
    }
    @GetMapping("/contacts/{id}")
    public ResponseEntity<ContactDto> getContact(@PathVariable Long id){
        return ResponseEntity.ok(contactService.getContact(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Long> addContact(@RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.createContact(contactDto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateContact(@PathVariable Long id, @RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.updateContact(id, contactDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteContact(@PathVariable Long id){
        return ResponseEntity.ok(contactService.deleteContact(id));
    }
}
