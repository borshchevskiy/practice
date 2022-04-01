package my.home.webapp.dto;

import lombok.Builder;
import lombok.Value;
import my.home.webapp.entity.Gender;
import my.home.webapp.entity.Role;

import java.time.LocalDate;

@Value
@Builder
public class UserDTO {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    String image;
    Role role;
    Gender gender;

}
