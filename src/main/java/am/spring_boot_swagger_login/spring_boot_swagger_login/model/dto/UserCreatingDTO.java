package am.spring_boot_swagger_login.spring_boot_swagger_login.model.dto;

import am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity.UserMedia;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class UserCreatingDTO {
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date birthDate;
    private String phoneNumber;
    private String eMail;
    private String userPassword;
    //private Set<UserMedia> userMedia;

}
