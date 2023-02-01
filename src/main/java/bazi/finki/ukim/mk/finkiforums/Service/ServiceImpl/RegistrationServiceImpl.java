package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Enumerations.UserType;
import bazi.finki.ukim.mk.finkiforums.Exceptions.InvalidUserTypeException;
import bazi.finki.ukim.mk.finkiforums.Exceptions.IndexNotFoundException;
import bazi.finki.ukim.mk.finkiforums.Model.Professor;
import bazi.finki.ukim.mk.finkiforums.Model.Student;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.StudentRepository;
import bazi.finki.ukim.mk.finkiforums.Response.UserResponse;
import bazi.finki.ukim.mk.finkiforums.Service.RegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public RegistrationServiceImpl(ProfessorRepository professorRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public UserResponse create(String name, String lastName, String email, String username, String password, UserType userType,String index) {
        if (userType.equals(UserType.PROFESSOR)){
            Professor professor = new Professor(name,lastName,username,email,password);
            professorRepository.save(professor);
            return new UserResponse(professor.getUsername(),UserType.PROFESSOR);
        }
        else if (userType.equals(UserType.STUDENT)){
            if (index==null){
                throw new IndexNotFoundException();
            }
            Student student = new Student(name,lastName,username,email,password,index);
            studentRepository.save(student);
            return new UserResponse(student.getUsername(),UserType.STUDENT);
        }
        else throw new InvalidUserTypeException(userType);
    }
}
