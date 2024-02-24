package dev.ebank.contact.web;

import dev.ebank.contact.model.dtos.ContactDto;
import dev.ebank.contact.model.entity.Contact;
import dev.ebank.contact.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PostMapping("/create/{id}")
    public ResponseEntity<Long> addContact(@PathVariable Long id, @Valid @RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.createContact(id, contactDto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateContact(@PathVariable Long id, @Valid @RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.updateContact(id, contactDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteContact(@PathVariable Long id){
        return ResponseEntity.ok(contactService.deleteContact(id));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName= ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return errors;
    }
}
