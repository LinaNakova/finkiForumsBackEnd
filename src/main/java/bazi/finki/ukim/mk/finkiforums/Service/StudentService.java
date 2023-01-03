package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAllStudents();

    Optional<Student> findStudentByUsername(String username);
}
