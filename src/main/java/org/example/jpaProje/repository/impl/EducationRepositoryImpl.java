package org.example.jpaProje.repository.impl;

import org.example.jpaProje.model.Advertisement;
import org.example.jpaProje.model.Education;
import org.example.jpaProje.repository.EducationRepository;

import javax.persistence.*;
import java.util.List;

public class EducationRepositoryImpl implements EducationRepository {

    private EntityManager entityManager= entityFactory.getEntityManager();
    private EntityTransaction transaction = this.entityManager.getTransaction();

    public boolean saveEducation(final Education education) {
        try {
            this.transaction.begin();
            this.entityManager.persist(education);
            this.transaction.commit();
        }
        catch (RuntimeException e) {
            System.err.println("Error: "+e);
            try {
                this.transaction.rollback();
            }
            catch (RollbackException er) {
                System.err.println("Error: "+er);
            }
            return false;
        }
        return true;
    }

    public boolean updateEducation(final Education education) {
        try {
            this.transaction.begin();
            this.entityManager.merge(education);
            this.entityManager.flush(); //güncellenmiş şekişde tabloyu alabilmek için
            this.transaction.commit();
        }
        catch (RuntimeException e) {
            System.err.println("Error: "+e);
            try {
                this.transaction.rollback();
            }
            catch (RollbackException er) {
                System.err.println("Error: "+er);
            }
            return false;
        }
        return true;
    }

    public boolean removeEducation(final Education education) {
        try {
            if(this.entityManager.contains(education)) {
                this.entityManager.remove(education);
            }
            else {
                Education deleteEducation = this.findById(education.getEducationId());
                this.entityManager.remove(deleteEducation);
            }
        }
        catch (RuntimeException e) {
            System.err.println("Error: "+e);
            try {
                this.transaction.rollback();
            }
            catch (RollbackException er) {
                System.err.println("Error: "+er);
            }
            return false;
        }
        return true;
    }

    public Education findById(Integer id) {
        Education education = null;

        try {
            education = this.entityManager.find(Education.class, id);
        }
        catch (NoResultException e) {
            System.err.println("Error: "+e);
        }
        return education;
    }

    public List<Education> findEducations() {
        List<Education> educations = null;
        try {
            TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findEducations", Education.class);

            educations = typedQuery.getResultList();
        }
        catch (NoResultException e) {
            System.err.println("Error: "+e);
        }
        return educations;
    }

    public Education findWithAdvertisementById(Integer id) {
        Education education = null;

        try {
            TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findWithAdvertisement", Education.class);
            typedQuery.setParameter("educationId",id);
            education = typedQuery.getSingleResult();
        }
        catch (NoResultException e) {
            System.err.println("Error: "+e);
        }
        return education;
    }
}
