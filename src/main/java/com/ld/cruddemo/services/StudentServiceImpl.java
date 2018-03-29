package com.ld.cruddemo.services;

import com.ld.cruddemo.commands.StudentCommand;
import com.ld.cruddemo.converters.StudentCommandToStudent;
import com.ld.cruddemo.converters.StudentToStudentCommand;
import com.ld.cruddemo.domain.Student;
import com.ld.cruddemo.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author luisdany  pernillo
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentToStudentCommand studentToStudentCommand;
    private final StudentCommandToStudent studentCommandToStudent;

    public StudentServiceImpl(StudentRepository studentRepository, StudentToStudentCommand studentToStudentCommand, StudentCommandToStudent studentCommandToStudent) {
        this.studentRepository = studentRepository;
        this.studentToStudentCommand = studentToStudentCommand;
        this.studentCommandToStudent = studentCommandToStudent;
    }

    @Override
    public Set<Student> getStudents() {

        Set<Student>  studentSet = new HashSet<>();
        studentRepository.findAll().iterator().forEachRemaining(studentSet::add);

        return studentSet;
    }

    @Override
    public Student findById(Long id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if(!studentOptional.isPresent()){
            throw  new RuntimeException("NO hay estudiantes!!");
        }

        return studentOptional.get();
    }

    @Override
    @Transactional
    public StudentCommand findCommandById(Long id) {
        return studentToStudentCommand.convert(findById(id));
    }

    @Override
    public void deleteById(Long id) {

    }
}
