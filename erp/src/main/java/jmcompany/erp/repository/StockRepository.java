package jmcompany.erp.repository;

import jakarta.persistence.EntityManager;
import jmcompany.erp.domain.Item;
import jmcompany.erp.domain.ItemInfo;
import jmcompany.erp.domain.Stock;
import jmcompany.erp.dto.StockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StockRepository {

    private final EntityManager em;

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
