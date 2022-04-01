package my.home.webapp.service;

import my.home.webapp.dao.UserDao;
import my.home.webapp.dto.CreateUserDto;
import my.home.webapp.dto.UserDTO;
import my.home.webapp.entity.User;
import my.home.webapp.service.exception.ValidationException;
import my.home.webapp.service.mapper.CreateUserMapper;
import my.home.webapp.service.mapper.UserMapper;
import my.home.webapp.service.validator.CreateUserValidator;
import my.home.webapp.service.validator.ValidationResult;

import java.io.IOException;
import java.util.Optional;

public class UserService {
        private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();

    private UserService() {

    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    public Optional<UserDTO> login(String email, String password){
        return userDao.findByEmailAndPassword(email,password)
                .map(userMapper::mapFrom);
    }

    public Integer create(CreateUserDto createUserDto) {
        ValidationResult validationResult = createUserValidator.isValid(createUserDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }

        User userEntity = createUserMapper.mapFrom(createUserDto);
        try {
            imageService.upload(userEntity.getImage(), createUserDto.getImage().getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userDao.save(userEntity);

        return userEntity.getId();
    }
}
