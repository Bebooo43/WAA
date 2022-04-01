package miu.edu.demo.repo;

import miu.edu.demo.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
//
//    List<Post> findAll();
//
//    List<Post> getPostByAuthor(String author);
}
