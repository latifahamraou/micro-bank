package dev.ebank.contact.repository;

import dev.ebank.contact.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findContactByIdUser(Long id);
    Optional<Contact> findByIban(String iban);
}
