package miu.edu.demo.service.impl;

import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.Userr;
import miu.edu.demo.domain.dto.CommentDto;
import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.domain.dto.UserDto;
import miu.edu.demo.helper.ListMapper;
import miu.edu.demo.repo.UserRepo;
import miu.edu.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Userr, UserDto> listMapperUser2Dto;
    @Autowired
    ListMapper<Post, PostDto> listMapperPost2Dto;
    @Autowired
    ListMapper<Comment, CommentDto> listMapperComment2Dto;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) listMapperUser2Dto.mapList((List<Userr>) userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getUserById(long id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public List<PostDto> getPostsOfUserById(long id) {
        return (List<PostDto>) listMapperPost2Dto.mapList(userRepo.findById(id).get().getPosts(), new PostDto());
    }

    @Override
    public void save(Userr user) {
        userRepo.save(user);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(int id, UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, Userr.class));
    }

    @Override
    public List<UserDto> getUsersWithPostsMoreThan(int postsNum) {
        return (List<UserDto>) listMapperUser2Dto.mapList(userRepo.getUsersWithPostsMoreThan(postsNum), new UserDto());
    }

    @Override
    public List<CommentDto> getCommentsOfPostByIdOfUserById(long userId, long postId) {
        var commentsList = userRepo.findById(userId).get()
                .getPosts().stream()
                .filter(p->p.getId() == postId)
                .findAny()
                .orElse(null)
                .getComments();

        return (List<CommentDto>) listMapperComment2Dto.mapList(commentsList, new CommentDto());
    }
}
