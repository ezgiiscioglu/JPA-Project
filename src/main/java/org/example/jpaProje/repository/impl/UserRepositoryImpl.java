package org.example.jpaProje.repository.impl;

import org.example.jpaProje.model.*;
import org.example.jpaProje.repository.UserRepository;

import javax.persistence.*;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private EntityManager entityManager= entityFactory.getEntityManager();
    private EntityTransaction transaction = this.entityManager.getTransaction();

    public boolean saveUser(final User user) {
        try {
            this.transaction.begin();
            this.entityManager.persist(user);
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

    public boolean updateUser(final User user) {
        try {
            this.transaction.begin();
            this.entityManager.merge(user);
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

    public boolean removeUser(final User user) {
        try {
            if(this.entityManager.contains(user)) {
                this.entityManager.remove(user);
            }
            else {
                User deleteUser = this.findById(user.getUserId());
                this.entityManager.remove(deleteUser);
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

    public User findById(Integer id) {
        User user = null;

        try {
            user = this.entityManager.find(User.class, id);
        }
        catch (NoResultException e) {
            System.err.println("Error: "+e);
        }
        return user;
    }

    public User findByUsername(String username) {
        User user = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findByUsername", User.class);
            typedQuery.setParameter("username", username);

            user = typedQuery.getSingleResult();
        }
        catch (NoResultException e) {
            System.err.println(user + "couldn't find. Error: "+e);
        }
        return user;
    }

    public User findWithUserDetailByUsername(final String username) {
        User user = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findWithUserDetailByUsername", User.class);
            typedQuery.setParameter("username", username);

            user = typedQuery.getSingleResult();
        }
        catch (NoResultException e) {
            System.err.println(user + "couldn't find. Error: "+e);
        }
        return user;
    }

    public List<User> findUsers() {
        List<User> users = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);

            users = typedQuery.getResultList();
        }
        catch (NoResultException e) {
            System.err.println("Couldn't find this list. Error: "+e);
        }
        return users;
    }

    public List<User> findUserEntities(int firstResult, int maxResult) {
        List<User> users = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);
            typedQuery.setFirstResult(firstResult);
            typedQuery.setMaxResults(maxResult);
            users = typedQuery.getResultList();
        }
        catch (NoResultException e) {
            System.err.println("Couldn't find this list. Error: "+e);
        }
        return users;
    }

    public int findUserCount() {
        int count = 0;
        try {
            Query query = this.entityManager.createNamedQuery("User.count");
            count = (Integer) query.getSingleResult();

        } catch (NoResultException e) {
            System.err.println("Couldn't find users count. Error: " + e);
        }
        return count;
    }

    public UserInfo findUserInfoByUsername(String username) {
        UserInfo userInfo = null;
        try {
            TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("User.findUserInfoByUsername", UserInfo.class);
            typedQuery.setParameter("username", username);

            userInfo = typedQuery.getSingleResult();
        }
        catch (NoResultException e) {
            System.err.println("Couldn't find user info. Error: "+e);
        }
        return userInfo;
    }
}
