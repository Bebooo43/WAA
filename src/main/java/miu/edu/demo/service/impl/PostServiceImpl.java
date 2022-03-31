package miu.edu.demo.service.impl;

import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.helper.ListMapper;
import miu.edu.demo.repo.PostRepo;
import miu.edu.demo.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo repo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPost2Dto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapperPost2Dto.mapList(repo.findAll(), new PostDto());
    }

    @Override
    public PostDto getPostById(int id) {
        return modelMapper.map(repo.getPostById(id), PostDto.class);
    }

    @Override
    public void save(PostDto pDto) {
        repo.save(modelMapper.map(pDto, Post.class));
    }

    @Override
    public void delete(int id) {
        repo.delete(id);
    }

    @Override
    public void update(int id, PostDto pDto) {
        repo.update(id, modelMapper.map(pDto, Post.class));
    }

    @Override
    public List<PostDto> findAllPostsByAuthor(String author) {
        return (List<PostDto>) listMapperPost2Dto.mapList(repo.getPostByAuthor(author), new PostDto());
    }
}
