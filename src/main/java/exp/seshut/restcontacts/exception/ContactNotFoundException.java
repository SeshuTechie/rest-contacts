package exp.seshut.restcontacts.exception;

public class ContactNotFoundException  extends RuntimeException {
    public ContactNotFoundException(String id) {
        super("Could not find contact " + id);
    }
}
