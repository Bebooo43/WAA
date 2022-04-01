package miu.edu.demo.repo;

import miu.edu.demo.domain.Userr;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<Userr, Long> {


}
