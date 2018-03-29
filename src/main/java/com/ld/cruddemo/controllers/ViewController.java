package com.ld.cruddemo.controllers;

import com.ld.cruddemo.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author luisdany pernillo
 */
@Controller
public class ViewController {


    private final StudentService studentService;

    public ViewController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{studentId}/view")
    public String getStudent(@PathVariable String studentId, Model model){

        model.addAttribute("student", studentService.findById(new Long(studentId)));

        return "student/view";
    }

}
