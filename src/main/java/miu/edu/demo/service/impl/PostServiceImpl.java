package miu.edu.demo.service.impl;

import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.dto.CommentDto;
import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.helper.ListMapper;
import miu.edu.demo.repo.CommentRepo;
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
    CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPost2Dto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapperPost2Dto.mapList((List<Post>) repo.findAll(), new PostDto());
    }

    @Override
    public PostDto getPostById(long id) {
        return modelMapper.map(repo.findById(id), PostDto.class);
    }

    @Override
    public void save(PostDto pDto) {
        repo.save(modelMapper.map(pDto, Post.class));
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, PostDto pDto) {
        repo.save(modelMapper.map(pDto, Post.class));
    }

    @Override
    public List<PostDto> findAllPostsByTitle(String title) {
        return (List<PostDto>) listMapperPost2Dto.mapList(repo.findAllPostsByTitle(title), new PostDto());
    }

    @Override
    public void addComment(long postId, CommentDto cDto) {
        var post = repo.findById(postId).get();
        var comment = modelMapper.map(cDto, Comment.class);
        comment.setPost(post);
        commentRepo.save(comment);
    }
}
