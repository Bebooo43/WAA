package miu.edu.demo.repo;

import miu.edu.demo.domain.Userr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<Userr, Long> {


    @Query(value = "SELECT u from Userr u where u.posts.size > :postsNum")
    List<Userr> getUsersWithPostsMoreThan(int postsNum);
}
