package com.logcollege.confugration;


import com.logcollege.models.StudentDetails;
import com.logcollege.services.StudentDetailServices;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {
    private final StudentDetailServices services;

    public ViewController(StudentDetailServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title","Index Page");
        return "index";
    }

    @GetMapping("/addstudent")
    public String addStudents(Model model){
        model.addAttribute("title","Add Student Details");
        return "addstudents";
    }
    @GetMapping("/viewstudent")
    public String viewStudents(Model model){
        List<StudentDetails> studentDetails=services.getStudents();
        model.addAttribute("students",studentDetails);
        model.addAttribute("title","Student Details");
        return "studentdetails";
    }

    @GetMapping("/edit/{id}")
    public String editStudentDetails(@PathVariable("id") Integer id, Model model){
        model.addAttribute("student",services.getStudentById(id));
        model.addAttribute("title", " Student Details Edit Pages");
        return "editstudents";

        }
}
