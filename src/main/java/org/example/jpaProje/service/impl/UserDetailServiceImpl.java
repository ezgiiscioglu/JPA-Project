package org.example.jpaProje.service.impl;

import org.example.jpaProje.model.UserDetail;
import org.example.jpaProje.repository.UserDetailRepository;
import org.example.jpaProje.repository.impl.UserDetailRepositoryImpl;
import org.example.jpaProje.service.UserDetailService;

import javax.persistence.*;

public class UserDetailServiceImpl implements UserDetailService {
    private UserDetailRepositoryImpl userDetailRepository;

    public boolean saveUserDetail(UserDetail userDetail) {
        return this.userDetailRepository.saveUserDetail(userDetail);
    }

    public boolean updateUserDetail(UserDetail userDetail) {
        return this.userDetailRepository.updateUserDetail(userDetail);
    }

    public boolean removeUserDetail(UserDetail userDetail) {
        return this.userDetailRepository.removeUserDetail(userDetail);
    }

    public UserDetail findById(Integer id) {
        return this.userDetailRepository.findById(id);
    }

    public UserDetail findByUsername(String username) {
        return this.userDetailRepository.findByUsername(username);
    }

    public UserDetail findWithAddressByUsername(String username) {
        return this.userDetailRepository.findWithAddressByUsername(username);
    }

    public UserDetail findWithAdvertisementByUsername(String username) {
        return this.userDetailRepository.findWithAdvertisementByUsername(username);
    }
}
