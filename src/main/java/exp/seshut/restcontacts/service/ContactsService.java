package exp.seshut.restcontacts.service;

import exp.seshut.restcontacts.model.Contact;
import exp.seshut.restcontacts.exception.ContactNotFoundException;
import exp.seshut.restcontacts.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ContactsService {

    @Autowired
    private ContactRepo contactRepo;
    private AtomicLong counter = new AtomicLong();

    public Contact getContact(String id) {
        try {
            return contactRepo.findById(id).orElseThrow();
        } catch (NoSuchElementException ex) {
            throw new ContactNotFoundException(id);
        }
    }

    public Contact saveContact(Contact contact) {
//        long id = counter.incrementAndGet();
//        contact.setId(id);
        return contactRepo.save(contact);
    }

    public Contact updateContact(Contact contact) {
        try {
            contactRepo.findById(contact.getId()).orElseThrow();
        } catch (NoSuchElementException ex) {
            throw new ContactNotFoundException(contact.getId());
        }
        return contactRepo.save(contact);
    }

    public Contact deleteContact(String id) {
        Contact contact = null;
        try {
            contact = contactRepo.findById(id).orElseThrow();
        } catch (NoSuchElementException ex) {
            throw new ContactNotFoundException(contact.getId());
        }
        contactRepo.deleteById(id);
        return contact;
    }
}
