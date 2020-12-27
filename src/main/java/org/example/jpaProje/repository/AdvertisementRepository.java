package org.example.jpaProje.repository;

import org.example.jpaProje.entityFactory.EntityFactory;
import org.example.jpaProje.entityFactory.impl.EntityFactoryImpl;
import org.example.jpaProje.model.Advertisement;
import org.example.jpaProje.model.Education;

import java.util.List;

public interface AdvertisementRepository {
    EntityFactory entityFactory = new EntityFactoryImpl();
    boolean saveAdvertisement(Advertisement advertisement);
    boolean updateAdvertisement(Advertisement advertisement);
    boolean removeAdvertisement(Advertisement advertisement);
    Advertisement findById(Integer id);
    List<Advertisement> findByUsername(String username);
    List<Advertisement> findAdvertisements();
    List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult);
}
