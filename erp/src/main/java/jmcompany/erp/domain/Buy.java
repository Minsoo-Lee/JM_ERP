package jmcompany.erp.domain;

import jakarta.persistence.*;
import jmcompany.erp.dto.BuyDto;
import jmcompany.erp.dto.SellDto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Buy {

    @Id @GeneratedValue
    @Column(name = "BUY_ID")
    private Long id;

    private String date;
    private String customer;
    @Embedded
    @Column(name = "ITEM_INFO")
    private ItemInfo itemInfo;
    private String unit;
    private int quantity;
    private String currency;
    @Column(name = "UNIT_PRICE")
    private int unitPrice;
    private int price;
    private int vat;
    @Column(name = "TOTAL_PRICE")
    private int totalPrice;
    private String remarks;
    
    //== create method ==//
    public static Buy createBuy(String date, String customer, ItemInfo itemInfo, String unit, int quantity, String currency, int unitPrice, String remarks) {
        Buy buy = new Buy();
        buy.setDate(date);
        buy.setCustomer(customer);
        buy.setItemInfo(itemInfo);
        buy.setUnit(unit);
        buy.setQuantity(quantity);
        buy.setCurrency(currency);
        buy.setUnitPrice(unitPrice);
        buy.setPrice(unitPrice * quantity);
        buy.setVat((int) ((unitPrice * quantity) * 0.1));
        buy.setTotalPrice((int) ((unitPrice * quantity) * 1.1));

        buy.setRemarks(remarks);

        return buy;
    }

    public static Buy createNewBuy(BuyDto buyDto) {
        Buy buy = new Buy();
        buy.setDate(buyDto.getDate());
        buy.setCustomer(buyDto.getCustomer());
        buy.setItemInfo(new ItemInfo(buyDto.getItemNum(), buyDto.getItemNum()));
        buy.setUnit(buyDto.getUnit());
        buy.setQuantity(buyDto.getQuantity());
        buy.setCurrency(buyDto.getCurrency());
        buy.setUnitPrice(buyDto.getUnitPrice());
        buy.setPrice(buyDto.getUnitPrice() * buyDto.getQuantity());
        buy.setVat((int) ((buyDto.getUnitPrice() * buyDto.getQuantity()) * 0.1));
        buy.setTotalPrice((int) ((buyDto.getUnitPrice() * buyDto.getQuantity()) * 1.1));
        buy.setRemarks(buyDto.getRemarks());

        return buy;
    }
}