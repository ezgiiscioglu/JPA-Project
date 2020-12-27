package org.example.jpaProje.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.jpaProje.model.Education;
import org.example.jpaProje.repository.EducationRepository;
import org.example.jpaProje.repository.impl.EducationRepositoryImpl;
import org.example.jpaProje.service.EducationService;

import javax.persistence.*;
import java.util.List;
@RequiredArgsConstructor

public class EducationServiceImpl implements EducationService {
    private final EducationRepositoryImpl educationRepository;

    public boolean saveEducation(Education education) {
        return this.educationRepository.saveEducation(education);
    }

    public boolean updateEducation(Education education) {
        return this.educationRepository.updateEducation(education);
    }

    public boolean removeEducation(Education education) {
        return this.educationRepository.removeEducation(education);
    }

    public Education findById(Integer id) {
        return this.educationRepository.findById(id);
    }

    public List<Education> findEducations() {
        return this.educationRepository.findEducations();
    }

    public Education findWithAdvertisementById(Integer id) {
        return this.educationRepository.findWithAdvertisementById(id);
    }
}
