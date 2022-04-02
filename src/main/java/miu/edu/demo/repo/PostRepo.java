package miu.edu.demo.repo;

import miu.edu.demo.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    @Query(value = "SELECT p FROM Post p where p.title = :title")
    List<Post> findAllPostsByTitle(String title);
//
//    List<Post> findAll();
//
//    List<Post> getPostByAuthor(String author);
}
