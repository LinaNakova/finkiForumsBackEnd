package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Enumerations.UserType;
import bazi.finki.ukim.mk.finkiforums.Exceptions.BadUsernameException;
import bazi.finki.ukim.mk.finkiforums.Model.Admin;
import bazi.finki.ukim.mk.finkiforums.Model.Professor;
import bazi.finki.ukim.mk.finkiforums.Model.Student;
import bazi.finki.ukim.mk.finkiforums.Repository.AdminRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.StudentRepository;
import bazi.finki.ukim.mk.finkiforums.Response.UserResponse;
import bazi.finki.ukim.mk.finkiforums.Service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final AdminRepository adminRepository;

    public LoginServiceImpl(StudentRepository studentRepository, ProfessorRepository professorRepository, AdminRepository adminRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public UserResponse findUserByUsername(String username, String password) {
        if (this.adminRepository.findByUsername(username).isPresent())
        {
            Admin admin = this.adminRepository.findByUsername(username).get();
            if (admin.getPassword().equals(password)){
                return new UserResponse(admin.getUsername(), UserType.ADMIN);
            }
        }
        if (this.studentRepository.findByUsername(username).isPresent())
        {
            Student student = this.studentRepository.findByUsername(username).get();
            if (student.getPassword().equals(password)){
                return new UserResponse(student.getUsername(), UserType.STUDENT);
            }
        }
        if (this.professorRepository.findByUsername(username).isPresent())
        {
            Professor professor = this.professorRepository.findByUsername(username).get();
            if (professor.getPassword().equals(password)){
                return new UserResponse(professor.getUsername(), UserType.PROFESSOR);
            }
        }
        throw new BadUsernameException(username);
    }
}
