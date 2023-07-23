package jmcompany.erp.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Items {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Embedded
    @Column(name = "item_info")
    private ItemInfo itemInfo;

    private String unit;

    @Column(name = "carry_over")
    private int carryOver;
    @Column(name = "real_stock")
    private int real_stock;

    private String madeBy;
    private String remarks;

    @OneToOne(mappedBy = "items")
    private Stocks stocks;
}
