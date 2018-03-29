package com.ld.cruddemo.controllers;


import com.ld.cruddemo.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luisdany pernillo
 * Esta clase sirve como controlador para la página index
 */
@Slf4j
@Controller
public class IndexController {

    private final StudentService studentService;

    /**
     * Constructor que inyecta el objeto studentService
     * @param studentService
     */
    public IndexController(StudentService studentService){
        this.studentService = studentService;
    }

    /**
     * Metodo que sirve para insertar el objeto students en la pagina de index
     * @param model
     * @return
     */
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("En el index!!!!!");
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }

}
