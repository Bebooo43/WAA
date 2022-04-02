package miu.edu.demo.service.impl;

import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.dto.CommentDto;
import miu.edu.demo.helper.ListMapper;
import miu.edu.demo.repo.CommentRepo;
import miu.edu.demo.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo repo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Comment, CommentDto> listMapperComment2Dto;

    @Override
    public List<CommentDto> findAll() {
        return (List<CommentDto>) listMapperComment2Dto.mapList((List<Comment>) repo.findAll(), new CommentDto());
    }

    @Override
    public CommentDto getCommentById(long id) {
        return modelMapper.map(repo.findById(id), CommentDto.class);
    }

    @Override
    public void save(CommentDto pDto) {
        repo.save(modelMapper.map(pDto, Comment.class));
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, CommentDto pDto) {
        repo.save(modelMapper.map(pDto, Comment.class));
    }

    
}
