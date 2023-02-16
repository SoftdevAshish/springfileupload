package com.logcollege.services;

import com.logcollege.models.StudentDetails;
import com.logcollege.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailServiceImpl implements StudentDetailServices {
    private final StudentRepo studentRepo;

    public StudentDetailServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public List<StudentDetails> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public StudentDetails addStudentDetails(StudentDetails studentDetails) {
        return studentRepo.save(studentDetails);
    }

    @Override
    public StudentDetails updateStudentDetails(StudentDetails studentDetails) {
        return studentRepo.save(studentDetails);
    }

    @Override
    public void deleteStudentDetails(int id) {
         studentRepo.deleteById(id);
    }

    @Override
    public StudentDetails getStudentById(int id) {
        return studentRepo.findById(id).get();
    }
}
