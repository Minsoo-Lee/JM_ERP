package jmcompany.erp.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ItemInfo {

    private String item_num;
    private String item_name;

    public ItemInfo() { }

    public ItemInfo(String item_num, String item_name) {
        this.item_num = item_num;
        this.item_name = item_name;
    }
}
