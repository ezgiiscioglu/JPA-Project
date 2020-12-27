package org.example.jpaProje.entityFactory.impl;

import org.example.jpaProje.entityFactory.EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactoryImpl implements EntityFactory {

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        return factory.createEntityManager();
    }
}
