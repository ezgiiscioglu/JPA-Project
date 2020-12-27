package org.example.jpaProje.service;

import org.example.jpaProje.model.User;
import org.example.jpaProje.model.UserInfo;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);
    boolean updateUser(User user);
    boolean removeUser(User user);
    User findById(Integer id);
    User findByUsername(String username);
    User findWithUserDetailByUsername(String username);
    List<User> findUsers();
    List<User> findUserEntities(int firstResult, int maxResult);
    int findUserCount();
    UserInfo findUserInfoByUsername(String username);
}
