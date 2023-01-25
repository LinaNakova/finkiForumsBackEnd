package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.Subject;
import bazi.finki.ukim.mk.finkiforums.Repository.SubjectRepository;
import bazi.finki.ukim.mk.finkiforums.Service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private  final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAllSubjects(){
        return this.subjectRepository.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return this.subjectRepository.findById(id).orElse(null);
        //add error handling
    }
}
