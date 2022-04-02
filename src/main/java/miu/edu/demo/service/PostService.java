package miu.edu.demo.service;

import miu.edu.demo.domain.dto.CommentDto;
import miu.edu.demo.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();
    PostDto getPostById(long id);
    void save(PostDto p);
    void delete(long id);
    void update(int id, PostDto p);

    List<PostDto> findAllPostsByTitle(String title);

    void addComment(long postId, CommentDto cDto);
}
