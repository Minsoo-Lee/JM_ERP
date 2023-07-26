package jmcompany.erp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemForm {

    private Long id;
    private String madeBy;
    private String itemNum;
    private String itemName;
    private String unit;
    private int carryOver;
    private int realStock;
    private String remarks;

    public static ItemForm createNewForm(Item item) {
        ItemForm itemForm = new ItemForm();
        itemForm.setId(item.getId());
        itemForm.setMadeBy(item.getMadeBy());
        itemForm.setItemNum(item.getItemInfo().getItemNum());
        itemForm.setItemName(item.getItemInfo().getItemName());
        itemForm.setUnit(item.getUnit());
        itemForm.setCarryOver(item.getCarryOver());
        itemForm.setRealStock(item.getRealStock());
        itemForm.setRemarks(item.getRemarks());
        return itemForm;
    }
}
