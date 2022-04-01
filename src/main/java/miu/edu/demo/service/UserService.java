package miu.edu.demo.service;

import miu.edu.demo.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto getUserById(long id);
    void save(UserDto p);
    void delete(long id);
    void update(int id, UserDto p);
}
