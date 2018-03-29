package com.ld.cruddemo.converters;

import com.ld.cruddemo.commands.StudentCommand;
import com.ld.cruddemo.domain.Student;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import org.springframework.core.convert.converter.Converter;

@Component
public class StudentToStudentCommand implements Converter<Student, StudentCommand>{

    @Synchronized
    @Nullable
    @Override
    public StudentCommand convert(Student student){
        if(student == null){
            return null;
        }

        final StudentCommand studentCommand = new StudentCommand();
        studentCommand.setId(student.getId());
        studentCommand.setAge(student.getAge());
        studentCommand.setEmail(student.getEmail());
        studentCommand.setName(student.getName());

        return studentCommand;
    }

}
