package jmcompany.erp.repository;

import jakarta.persistence.EntityManager;
import jmcompany.erp.domain.Item;
import jmcompany.erp.domain.Sell;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SellRepository {

    private final EntityManager em;

    public void save(Sell sell) {
        em.persist(sell);
    }

    public Sell findOne(Long id) {
        return em.find(Sell.class, id);
    }

    public List<Sell> findAll() {
        return em.createQuery("select s from Sell s", Sell.class)
                .getResultList();
    }
}
