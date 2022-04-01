package my.home.webapp.service.mapper;

import my.home.webapp.dto.CreateUserDto;
import my.home.webapp.entity.Gender;
import my.home.webapp.entity.Role;
import my.home.webapp.entity.User;
import my.home.webapp.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User>{
    private static final String IMAGE_FOLDER = "users/";
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    private CreateUserMapper(){

    }

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}
