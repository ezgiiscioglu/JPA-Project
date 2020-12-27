package org.example.jpaProje.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.jpaProje.model.User;
import org.example.jpaProje.model.UserInfo;
import org.example.jpaProje.repository.UserRepository;
import org.example.jpaProje.repository.impl.UserRepositoryImpl;
import org.example.jpaProje.service.UserService;

import javax.persistence.*;
import java.util.List;
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepositoryImpl userRepository;

    public boolean saveUser(User user) {
        return this.userRepository.saveUser(user);
    }

    public boolean updateUser(User user) {
        return this.userRepository.updateUser(user);
    }

    public boolean removeUser(User user) {
        return this.userRepository.removeUser(user);
    }

    public User findById(Integer id) {
        return this.userRepository.findById(id);
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User findWithUserDetailByUsername(String username) {
        return this.userRepository.findWithUserDetailByUsername(username);
    }

    public List<User> findUsers() {
        return this.userRepository.findUsers();
    }

    public List<User> findUserEntities(int firstResult, int maxResult) {
        return this.userRepository.findUserEntities(firstResult, maxResult);
    }

    public int findUserCount() {
        return this.userRepository.findUserCount();
    }

    public UserInfo findUserInfoByUsername(String username) {
        return this.userRepository.findUserInfoByUsername(username);
    }
}
