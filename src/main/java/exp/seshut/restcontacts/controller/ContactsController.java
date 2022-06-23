package exp.seshut.restcontacts.controller;

import exp.seshut.restcontacts.model.Contact;
import exp.seshut.restcontacts.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactsController {

    @Autowired
    private ContactsService contactService;

    @GetMapping("/contact/{id}")
    public Contact getMapping(@PathVariable String id) {
        return contactService.getContact(id);
    }

    @PostMapping("/contact/new")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @PutMapping("/contact")
    public Contact updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/contact/{id}")
    public Contact deleteMapping(@PathVariable String id) {
        return contactService.deleteContact(id);
    }
}
