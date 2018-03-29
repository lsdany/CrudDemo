package com.ld.cruddemo.services;

import com.ld.cruddemo.commands.StudentCommand;
import com.ld.cruddemo.domain.Student;

import java.util.Set;

/**
 * @author luisdany
 */
public interface StudentService {

    Set<Student> getStudents();

    Student findById(Long id);

    StudentCommand findCommandById(Long id);

    void deleteById(Long id);
}
