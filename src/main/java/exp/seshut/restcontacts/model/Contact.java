package exp.seshut.restcontacts.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Contact")
@NoArgsConstructor
public class Contact {
    @Id
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String notes;
}
