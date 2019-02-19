package am.spring_boot_swagger_login.spring_boot_swagger_login.dtoMapper;

import am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity.User;
import am.spring_boot_swagger_login.spring_boot_swagger_login.model.dto.UserCreatingDTO;

public class UserDTOUtil {
    public static User convertToEntity(UserCreatingDTO userCreatingDTO) {
        return User.builder().birthDate(userCreatingDTO.getBirthDate())
                .eMail(userCreatingDTO.getEMail())
                .firstName(userCreatingDTO.getFirstName())
                .phoneNumber(userCreatingDTO.getPhoneNumber())
                .userPassword(userCreatingDTO.getUserPassword())
                .lastName(userCreatingDTO.getLastName()).build();
    }
}
