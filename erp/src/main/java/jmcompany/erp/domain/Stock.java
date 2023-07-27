package jmcompany.erp.domain;

import jakarta.persistence.*;
import jmcompany.erp.dto.StockDto;
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

    @OneToOne(cascade = CascadeType.ALL)
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

    public static Stock createNewStock(StockDto stockDto) {
        Stock stock = new Stock();
        stock.setBuy(stockDto.getBuy());
        stock.setSell(stockDto.getSell());
        stock.setStockAmount(stockDto.getStockAmount());

        Item item = new Item();
        item.setItemInfo(new ItemInfo(stockDto.getItemNum(), stockDto.getItemName()));
        item.setUnit(stockDto.getUnit());
        item.setCarryOver(stockDto.getCarryOver());
        item.setRealStock(stockDto.getRealStock());
        item.setMadeBy(stockDto.getMadeBy());
        item.setRemarks(stockDto.getRemarks());
        stock.setItem(item);

        return stock;
    }
}
