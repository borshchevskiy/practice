package my.home.webapp.service.mapper;

import my.home.webapp.dto.UserDTO;
import my.home.webapp.entity.User;

public class UserMapper implements Mapper<User, UserDTO> {

    private static final UserMapper INSTANCE = new UserMapper();

    private UserMapper(){

    }

    @Override
    public UserDTO mapFrom(User object) {
        return UserDTO.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }

    public static UserMapper getInstance(){
        return INSTANCE;
    }
}
