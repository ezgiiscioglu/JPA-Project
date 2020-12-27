package org.example.jpaProje.service;

import org.example.jpaProje.model.UserDetail;

public interface UserDetailService {
    boolean saveUserDetail(UserDetail userDetail);
    boolean updateUserDetail(UserDetail userDetail);
    boolean removeUserDetail(UserDetail userDetail);
    UserDetail findById(Integer id);
    UserDetail findByUsername(String username);
    UserDetail findWithAddressByUsername(String username);
    UserDetail findWithAdvertisementByUsername(String username);
}
