package exp.seshut.restcontacts.service;

import exp.seshut.restcontacts.Contact;
import exp.seshut.restcontacts.exception.ContactNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ContactsService {

    //Storing contacts in cache for demo purpose
    private Map<Long, Contact> contactMap = new HashMap<>();
    private AtomicLong counter = new AtomicLong();

    public Contact getContact(long id) {
        if(!contactMap.containsKey(id)) {
            throw new ContactNotFoundException(id);
        }
        return contactMap.get(id);
    }

    public Contact saveContact(Contact contact) {
        long id = counter.incrementAndGet();
        contact.setId(id);
        contactMap.put(id, contact);
        return contact;
    }

    public Contact updateContact(Contact contact) {
        if(!contactMap.containsKey(contact.getId())) {
            throw new ContactNotFoundException(contact.getId());
        }
        contactMap.put(contact.getId(), contact);
        return contact;
    }

    public Contact deleteContact(long id) {
        if(!contactMap.containsKey(id)) {
            throw new ContactNotFoundException(id);
        }
        return contactMap.remove(id);
    }
}
