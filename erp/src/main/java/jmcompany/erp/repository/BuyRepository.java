package jmcompany.erp.repository;

import jakarta.persistence.EntityManager;
import jmcompany.erp.domain.Buy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BuyRepository {

    private final EntityManager em;

    public void save(Buy buy) {
        em.persist(buy);
    }

    public Buy findOne(Long id) {
        return em.find(Buy.class, id);
    }

    public List<Buy> findAll() {
        return em.createQuery("select s from Buy s", Buy.class)
                .getResultList();
    }
}
