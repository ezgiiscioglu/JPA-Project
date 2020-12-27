package org.example.jpaProje.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.jpaProje.model.Advertisement;
import org.example.jpaProje.repository.AdvertisementRepository;
import org.example.jpaProje.repository.impl.AdvertisementRepositoryImpl;
import org.example.jpaProje.service.AdvertisementService;

import javax.persistence.*;
import java.util.List;
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {
    //private AdvertisementRepository advertisementRepository = new AdvertisementRepositoryImpl();
    private final AdvertisementRepositoryImpl advertisementRepository;

    public boolean saveAdvertisement(Advertisement advertisement) {
        return advertisementRepository.saveAdvertisement(advertisement);
    }

    public boolean updateAdvertisement(Advertisement advertisement) {
        return advertisementRepository.updateAdvertisement(advertisement);
    }

    public boolean removeAdvertisement(Advertisement advertisement) {
        return advertisementRepository.removeAdvertisement(advertisement);
    }

    public Advertisement findById(Integer id) {
        return advertisementRepository.findById(id);
    }

    public List<Advertisement> findByUsername(String username) {
        return this.advertisementRepository.findByUsername(username);
    }

    public List<Advertisement> findAdvertisements() {
        return this.advertisementRepository.findAdvertisements();
    }

    public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {
        return this.advertisementRepository.findAdvertisementEntities(firstResult,maxResult);
    }
}
