package exp.seshut.restcontacts;

import lombok.Data;

@Data
public class Contact {
    private Long id;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String notes;
}
