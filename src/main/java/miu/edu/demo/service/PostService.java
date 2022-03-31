package miu.edu.demo.service;

import miu.edu.demo.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();
    PostDto getPostById(int id);
    void save(PostDto p);
    void delete(int id);
    void update(int id, PostDto p);

    List<PostDto> findAllPostsByAuthor(String author);
}
