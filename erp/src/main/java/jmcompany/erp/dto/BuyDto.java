package jmcompany.erp.dto;


import jmcompany.erp.domain.Buy;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BuyDto {

    private Long id;
    private String date;
    private String customer;
    private String itemNum;
    private String itemName;
    private String unit;
    private int quantity;
    private String currency;
    private int unitPrice;
    private int price;
    private int vat;
    private int totalPrice;
    private String remarks;

    public static BuyDto createNewForm(Buy buy) {
        BuyDto buyDto = new BuyDto();
        buyDto.setId(buy.getId());
        buyDto.setDate(buy.getDate());
        buyDto.setCustomer(buy.getCustomer());
        buyDto.setItemNum(buy.getItemInfo().getItemNum());
        buyDto.setItemName(buy.getItemInfo().getItemName());
        buyDto.setUnit(buy.getUnit());
        buyDto.setQuantity(buy.getQuantity());
        buyDto.setCurrency(buy.getCurrency());
        buyDto.setUnitPrice(buy.getUnitPrice());
        buyDto.setPrice(buy.getPrice());
        buyDto.setVat(buy.getVat());
        buyDto.setTotalPrice(buy.getTotalPrice());
        buyDto.setRemarks(buy.getRemarks());
        return buyDto;
    }
}
