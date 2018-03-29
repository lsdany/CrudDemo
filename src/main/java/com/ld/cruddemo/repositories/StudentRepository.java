package com.ld.cruddemo.repositories;

import com.ld.cruddemo.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


/**
 * @author luisdany pernillo
 */
public interface StudentRepository extends CrudRepository <Student, Long>{

    Optional<Student> findById(String id);

}
