package jmcompany.erp.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Buy {

    @Id @GeneratedValue
    @Column(name = "BUY_ID")
    private Long id;

    private String date;
    private String customer;
    @Embedded
    @Column(name = "ITEM_INFO")
    private ItemInfo itemInfo;
    private int unit;
    private int quantity;
    private String currency;
    @Column(name = "UNIT_PRICE")
    private int unitPrice;
    private int price;
    private int vat;
    @Column(name = "TOTAL_PRICE")
    private int totalPrice;
    private String remarks;
}