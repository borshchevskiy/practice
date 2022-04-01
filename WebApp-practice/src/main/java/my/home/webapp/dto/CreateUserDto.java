package my.home.webapp.dto;

import jakarta.servlet.http.Part;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public  class CreateUserDto {
    String name;
    String birthday;
    String email;
    Part image;
    String password;
    String role;
    String gender;

}
