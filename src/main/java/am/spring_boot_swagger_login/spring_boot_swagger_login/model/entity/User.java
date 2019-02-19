package am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity(name = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Please provide FIRST NAME")
    @Column
    private String firstName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + eMail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    @NotNull
    @NotEmpty(message = "Please provide LAST NAME")
    @Column
    private String lastName;

    @Column
    private Date birthDate;

    @NotNull
    @NotEmpty(message = "Please provide PHONE NUMBER")
    @Column
    private String phoneNumber;

    @NotNull
    @Email(message = "Please provide a valid E-Mail AND Try Again")
    @NotEmpty(message = "Please provide an E-Mail")
    @Column
    private String eMail;

    @NotNull
    @NotEmpty(message = "Please provide USER PASSWORD")
    @Column
    private String userPassword;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserMedia> userMedia;


}
