package miu.edu.demo.repo;

import miu.edu.demo.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends CrudRepository<Logger, Long> {

}
