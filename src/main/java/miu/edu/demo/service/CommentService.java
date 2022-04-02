package miu.edu.demo.service;

import miu.edu.demo.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAll();
    CommentDto getCommentById(long id);
    void save(CommentDto c);
    void delete(long id);
    void update(int id, CommentDto c);

}
