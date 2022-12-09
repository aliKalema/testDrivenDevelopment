package co.ke.personal.testdrivendevelopment.repository;

import co.ke.personal.testdrivendevelopment.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
