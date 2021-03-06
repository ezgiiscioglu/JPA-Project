package org.example.jpaProje.repository;

import org.example.jpaProje.entityFactory.EntityFactory;
import org.example.jpaProje.entityFactory.impl.EntityFactoryImpl;
import org.example.jpaProje.model.UserDetail;

public interface UserDetailRepository {
    EntityFactory entityFactory = new EntityFactoryImpl();
    boolean saveUserDetail(UserDetail userDetail);
    boolean updateUserDetail(UserDetail userDetail);
    boolean removeUserDetail(UserDetail userDetail);
    UserDetail findById(Integer id);
    UserDetail findByUsername(String username);
    UserDetail findWithAddressByUsername(String username);
    UserDetail findWithAdvertisementByUsername(String username);
}
