package springbootex302.demo;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository <ToDo, Long>{
}
