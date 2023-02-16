package com.logcollege.services;

import com.logcollege.models.StudentDetails;

import java.util.List;

public interface StudentDetailServices {

     List<StudentDetails>  getStudents();
    public StudentDetails addStudentDetails(StudentDetails studentDetails);
    StudentDetails updateStudentDetails(StudentDetails studentDetails);
    void deleteStudentDetails(int id);
    public StudentDetails getStudentById(int id);
}
