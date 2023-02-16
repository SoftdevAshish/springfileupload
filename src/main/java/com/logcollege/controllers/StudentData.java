package com.logcollege.controllers;


import com.logcollege.models.StudentDetails;
import com.logcollege.services.StudentDetailServices;
import com.logcollege.utils.FileHandling;
import com.logcollege.utils.FileHandlingImpl;
import jakarta.servlet.annotation.MultipartConfig;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@MultipartConfig
public class StudentData {

    private final FileHandling fileHandling;
    private final StudentDetailServices services;
    String delFile;


    public StudentData(FileHandlingImpl fileHandling, StudentDetailServices services) {
        this.fileHandling = fileHandling;
        this.services = services;
    }
    @PostMapping("/add")
    public String addStudent(@RequestParam("name") String name,@RequestParam("profilePicture") MultipartFile file,@RequestParam("address") String address,@RequestParam("faculty") String faculty,@RequestParam("contact") String contact, Model model) {
        if (name.length()>0 && file.getSize()>0 && address.length()>0 && faculty.length()>0 && contact.length()>0){
            StudentDetails student=new StudentDetails();
            student.setName(name);
            String fileNewName=fileHandling.fileNewName(file.getOriginalFilename());
            student.setProfilePicture(fileNewName);
            student.setFaculty(faculty);
            student.setAddress(address);
            student.setContact(contact);
            StudentDetails sd=services.addStudentDetails(student);
//          System.out.println(sd);

            if (sd!=null && file.getSize()>0){
                boolean fup = fileHandling.upload(file, fileNewName);
            }
        }
        return "redirect:/viewstudent";
    }
    @PostMapping("/update")
    public String updateStudent(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("profilePicture") MultipartFile file,@RequestParam("address") String address,@RequestParam("faculty") String faculty,@RequestParam("contact") String contact, Model model) {
        if (name.length()>0 && address.length()>0 && faculty.length()>0 && contact.length()>0){
            StudentDetails student=new StudentDetails();
            String fileName=null;
            StudentDetails std=services.getStudentById(id);
            this.delFile=std.getProfilePicture();
            if (file.getSize()>0){
                fileName=fileHandling.fileNewName(file.getOriginalFilename());
            }else {

                fileName =delFile;
            }
            student.setId(id);
            student.setName(name);
            student.setFaculty(faculty);
            student.setProfilePicture(fileName);
            student.setAddress(address);
            student.setContact(contact);
            StudentDetails sd=services.addStudentDetails(student);
            if (sd!=null && file.getSize()>0){
                boolean fup = fileHandling.upload(file, fileName);
                if (fup) {
                    fileHandling.deleteUploadFile(delFile);
                }
            }
        }
        return "redirect:/viewstudent";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudentDetails(@PathVariable("id") Integer id, Model model){
        if (id>0){
            String deleteFile=services.getStudentById(id).getProfilePicture();
            services.deleteStudentDetails(id);
            fileHandling.deleteUploadFile(deleteFile);
        }

        return "redirect:/viewstudent";
    }



}
