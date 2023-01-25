package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAllSubjects();
    Subject findById(Long id);
}
