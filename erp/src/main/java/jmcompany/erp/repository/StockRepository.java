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

    public void update(StockDto dto) {
        Stock stock = findOne(dto.getId());
        stock.setBuy(dto.getBuy());
        stock.setSell(dto.getSell());
        stock.setStockAmount(dto.getStockAmount());

        Item item = new Item();
        item.setItemInfo(new ItemInfo(dto.getItemNum(), dto.getItemName()));
        item.setUnit(dto.getUnit());
        item.setCarryOver(dto.getCarryOver());
        item.setRealStock(dto.getRealStock());
        item.setMadeBy(dto.getMadeBy());
        item.setRemarks(dto.getRemarks());
        stock.setItem(item);
    }
}
