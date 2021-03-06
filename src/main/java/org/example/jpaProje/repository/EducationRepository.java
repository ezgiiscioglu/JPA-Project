package org.example.jpaProje.repository;

import org.example.jpaProje.model.Education;
import org.example.jpaProje.entityFactory.EntityFactory;
import org.example.jpaProje.entityFactory.impl.EntityFactoryImpl;

import java.util.List;

public interface EducationRepository {
    EntityFactory entityFactory = new EntityFactoryImpl();
    boolean saveEducation(Education education);
    boolean updateEducation(Education education);
    boolean removeEducation(Education education);
    Education findById(Integer id);
    List<Education> findEducations();
    Education findWithAdvertisementById(Integer id);

}
