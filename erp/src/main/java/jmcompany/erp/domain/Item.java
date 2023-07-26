package jmcompany.erp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Item {

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
    private int realStock;

    private String madeBy;
    private String remarks;

    @OneToOne(mappedBy = "item")
    private Stock stock;

    //== create ==//
    public static Item createItem(String item_num, String item_name, String unit, int carryOver, int real_stock, String madeBy, String remarks) {
        Item item = new Item();
        item.setItemInfo(new ItemInfo(item_num, item_name));
        item.setUnit(unit);
        item.setCarryOver(carryOver);
        item.setRealStock(real_stock);
        item.setMadeBy(madeBy);
        item.setRemarks(remarks);

        return item;
    }

    public static Item createNewItem(ItemForm form) {
        Item item = new Item();
        item.setItemInfo(new ItemInfo(form.getItemNum(), form.getItemName()));
        item.setUnit(form.getUnit());
        item.setCarryOver(form.getCarryOver());
        item.setRealStock(form.getRealStock());
        item.setMadeBy(form.getMadeBy());
        item.setRemarks(form.getRemarks());

        return item;
    }
}
