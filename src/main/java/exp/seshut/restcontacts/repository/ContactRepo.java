package exp.seshut.restcontacts.repository;

import exp.seshut.restcontacts.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepo extends MongoRepository<Contact, String> {
}
