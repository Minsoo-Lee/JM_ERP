package jmcompany.erp.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
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
}
