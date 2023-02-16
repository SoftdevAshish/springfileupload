package com.logcollege.repository;

import com.logcollege.models.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentDetails, Integer> {
}
