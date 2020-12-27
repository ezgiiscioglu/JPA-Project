package org.example.jpaProje.service;

import org.example.jpaProje.model.Education;

import java.util.List;

public interface EducationService {
    boolean saveEducation(Education education);
    boolean updateEducation(Education education);
    boolean removeEducation(Education education);
    Education findById(Integer id);
    List<Education> findEducations();
    Education findWithAdvertisementById(Integer id);

}
