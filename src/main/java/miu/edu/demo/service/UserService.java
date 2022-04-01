package miu.edu.demo.service;

import miu.edu.demo.domain.Userr;
import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto getUserById(long id);
    List<PostDto> getPostsOfUserById(long id);
    void save(Userr user);
    void delete(long id);
    void update(int id, UserDto p);
}
