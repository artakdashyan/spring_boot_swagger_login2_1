package am.spring_boot_swagger_login.spring_boot_swagger_login.dtoMapper;

import am.spring_boot_swagger_login.spring_boot_swagger_login.model.dto.UserMediaCreatingDTO;
import am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity.UserMedia;

public class UserMediaDTOUtil {

    public static UserMedia convertToEntity(UserMediaCreatingDTO userMediaCreatingDTO){
        return UserMedia.builder().photoUrl(userMediaCreatingDTO.getPhotoUrl())
                .user_id(userMediaCreatingDTO.getUser_id()).build();

    }
}
