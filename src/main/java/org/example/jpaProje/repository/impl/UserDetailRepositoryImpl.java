package org.example.jpaProje.repository.impl;

import org.example.jpaProje.model.UserDetail;
import org.example.jpaProje.repository.UserDetailRepository;

import javax.persistence.*;

public class UserDetailRepositoryImpl implements UserDetailRepository {
    private EntityManager entityManager= entityFactory.getEntityManager();
    private EntityTransaction transaction = this.entityManager.getTransaction();


    public boolean saveUserDetail(final UserDetail userDetail) {
        try {
            this.transaction.begin();
            this.entityManager.persist(userDetail);
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

    public boolean updateUserDetail(final UserDetail userDetail) {
        try {
            this.transaction.begin();
            this.entityManager.merge(userDetail);
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

    public boolean removeUserDetail(final UserDetail userDetail) {
        try {
            if(this.entityManager.contains(userDetail)) {
                this.entityManager.remove(userDetail);
            }
            else {
                UserDetail deleteUserDetail = this.findById(userDetail.getUserDetailId());
                this.entityManager.remove(deleteUserDetail);
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

    public UserDetail findById(Integer id) {
        UserDetail userDetail = null;

        try {
            userDetail = this.entityManager.find(UserDetail.class, id);
        }
        catch (NoResultException e) {
            System.err.println("Error: "+e);
        }
        return userDetail;
    }

    public UserDetail findByUsername(String username) {
        UserDetail userDetail = null;
        try {
            TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findByUsername", UserDetail.class);
            typedQuery.setParameter("username", username);

            userDetail = typedQuery.getSingleResult();
        }
        catch (NoResultException e) {
            System.err.println("Error: "+e);
        }
        return userDetail;
    }

    public UserDetail findWithAddressByUsername(final String username) {
        UserDetail userDetail = null;
        try {
            TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithAddressByUsername", UserDetail.class);
            typedQuery.setParameter("username", username);

            userDetail = typedQuery.getSingleResult();
        }
        catch (NoResultException e) {
            System.err.println("Error: "+e);
        }
        return userDetail;
    }

    public UserDetail findWithAdvertisementByUsername(final String username) {
        UserDetail userDetail = null;
        try {
            TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithAdvertisementByUsername", UserDetail.class);
            typedQuery.setParameter("username", username);

            userDetail = typedQuery.getSingleResult();
        }
        catch (NoResultException e) {
            System.err.println("Error: "+e);
        }
        return userDetail;
    }
}
