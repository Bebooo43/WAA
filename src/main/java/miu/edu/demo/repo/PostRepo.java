package miu.edu.demo.repo;

import miu.edu.demo.domain.Post;

import java.util.List;

public interface PostRepo {

    List<Post> findAll();
    Post getPostById(int id);
    void save(Post p);
    void delete(int id);
    void update(int id, Post p);

    List<Post> getPostByAuthor(String author);
}
