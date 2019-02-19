package am.spring_boot_swagger_login.spring_boot_swagger_login.model.dto;

import am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMediaCreatingDTO {
    private String photoUrl;
    private Long user_id;
    //private User user;

}
