package jmcompany.erp;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jmcompany.erp.domain.Item;
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
        //initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Item item = Item.createItem("113343", "Craft Airbag", "-", 32, 0, "Aktas", "none");
            em.persist(item);

            Stock stock = Stock.createStock(0, 20, 0, item);
            em.persist(stock);
        }
    }

}
