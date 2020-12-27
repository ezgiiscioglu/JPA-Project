package org.example.jpaProje.entityFactory;

import javax.persistence.EntityManager;

public interface EntityFactory {
    EntityManager getEntityManager();
}
