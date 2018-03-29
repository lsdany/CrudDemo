package com.ld.cruddemo.converters;


import com.ld.cruddemo.commands.StudentCommand;
import com.ld.cruddemo.domain.Student;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author luisdany pernillo
 */
@Component
public class StudentCommandToStudent implements Converter<StudentCommand, Student>{

    @Synchronized
    @Nullable
    @Override
    public Student convert(StudentCommand studentCommand) {

        if(studentCommand == null){
            return null;
        }

        final Student student = new Student();
        student.setAge(studentCommand.getAge());
        student.setEmail(studentCommand.getEmail());
        student.setId(studentCommand.getId());
        student.setName(studentCommand.getName());

        return student;

    }
}
