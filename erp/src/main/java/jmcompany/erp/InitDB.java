package jmcompany.erp;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jmcompany.erp.domain.Item;
import jmcompany.erp.domain.ItemInfo;
import jmcompany.erp.domain.Sell;
import jmcompany.erp.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 총 주문 2개
 */
@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            ItemInfo itemInfo = new ItemInfo("113343", "Craft Airbag");
            Item item = Item.createItem(itemInfo, "-", 32, 0, "Aktas", "none");
            em.persist(item);

            Stock stock = Stock.createStock(0, 20, 0, item);
            em.persist(stock);

            Sell sell = Sell.createSell("2022-03-01", "Filkar", "한국특장차", itemInfo, "1ea", 20, 58000, "none");
            em.persist(sell);
        }
    }

}
