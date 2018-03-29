package com.ld.cruddemo.controllers;

import com.ld.cruddemo.domain.Student;
import com.ld.cruddemo.services.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * @author luisdany pernillo
 */
public class ViewControllerTest {

    @Mock
    StudentService studentService;

    ViewController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        controller = new ViewController(studentService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetStudent() throws Exception {

        Student student = new Student();
        student.setId(1l);

        when(studentService.findById(anyLong())).thenReturn(student);

        mockMvc.perform(get("/student/1/view"))
                .andExpect(status().isOk())
                .andExpect(view().name("student/view"))
                .andExpect(model().attributeExists("student"));


    }
}