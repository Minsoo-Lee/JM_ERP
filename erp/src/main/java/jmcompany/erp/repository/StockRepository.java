package jmcompany.erp.repository;

import jakarta.persistence.EntityManager;
import jmcompany.erp.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StockRepository {

    private EntityManager em;

    public void save(Stock stock) {
        em.persist(stock);
    }

    public Stock findOne(Long id) {
        return em.find(Stock.class, id);
    }

    public List<Stock> findAll() {
        return em.createQuery("select s from Stock s", Stock.class)
                .getResultList();
    }
}
