package jmcompany.erp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Stock {

    @Id @GeneratedValue
    @Column(name = "STOCK_ID")
    private Long id;

    private int buy;
    private int sell;
    @Column(name = "STOCK_AMOUNT")
    private int stockAmount;

    @OneToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    //== create ==//
    public static Stock createStock(int buy, int sell, int stockAmount, Item item) {
        Stock stock = new Stock();
        stock.setBuy(buy);
        stock.setSell(sell);
        stock.setStockAmount(stockAmount);
        stock.setItem(item);

        return stock;
    }
}
