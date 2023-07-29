package jmcompany.erp.domain;

import jakarta.persistence.*;
import jmcompany.erp.dto.SellDto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Sell {

    @Id @GeneratedValue
    @Column(name = "SELL_ID")
    private Long id;

    private String date;
    private String madeBy;
    private String customer;

    @Embedded
    @Column(name = "ITEM_INFO")
    private ItemInfo itemInfo;

    private String unit;
    private int quantity;
    @Column(name = "UNIT_PRICE")
    private int unitPrice;
    private int price;
    private int vat;
    @Column(name = "TOTAL_PRICE")
    private int totalPrice;
    private String remarks;

    public static Sell createSell(String date, String madeBy, String customer, ItemInfo itemInfo, String unit, int quantity, int unitPrice, String remarks) {
        Sell sell = new Sell();
        sell.setDate(date);
        sell.setMadeBy(madeBy);
        sell.setCustomer(customer);
        sell.setItemInfo(itemInfo);
        sell.setUnit(unit);
        sell.setQuantity(quantity);
        sell.setUnitPrice(unitPrice);

        sell.setPrice(unitPrice * quantity);
        sell.setVat((int) ((unitPrice * quantity) * 0.1));
        sell.setTotalPrice((int) ((unitPrice * quantity) * 1.1));

        sell.setRemarks(remarks);

        return sell;
    }

    public static Sell createNewSell(SellDto sellDto) {
        Sell sell = new Sell();
        sell.setDate(sellDto.getDate());
        sell.setMadeBy(sellDto.getMadeBy());
        sell.setCustomer(sellDto.getCustomer());
        sell.setItemInfo(new ItemInfo(sellDto.getItemNum(), sellDto.getItemNum()));
        sell.setUnit(sellDto.getUnit());
        sell.setQuantity(sellDto.getQuantity());
        sell.setUnitPrice(sellDto.getUnitPrice());
        sell.setPrice(sellDto.getUnitPrice() * sellDto.getQuantity());
        sell.setVat((int) ((sellDto.getUnitPrice() * sellDto.getQuantity()) * 0.1));
        sell.setTotalPrice((int) ((sellDto.getUnitPrice() * sellDto.getQuantity()) * 1.1));
        sell.setRemarks(sellDto.getRemarks());

        return sell;
    }
}
