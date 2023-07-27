package jmcompany.erp.dto;

import jmcompany.erp.domain.Stock;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StockDto {

    private Long id;
    private String itemNum;
    private String itemName;
    private String unit;
    private int carryOver;
    private int buy;
    private int sell;
    private int stockAmount;
    private String madeBy;
    private int realStock;
    private String remarks;


    public static StockDto createNewForm(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setId(stock.getId());
        stockDto.setItemNum(stock.getItem().getItemInfo().getItemNum());
        stockDto.setItemName(stock.getItem().getItemInfo().getItemName());
        stockDto.setUnit(stock.getItem().getUnit());
        stockDto.setCarryOver(stock.getItem().getCarryOver());
        stockDto.setBuy(stock.getBuy());
        stockDto.setSell(stock.getSell());
        stockDto.setStockAmount(stock.getStockAmount());
        stockDto.setMadeBy(stock.getItem().getMadeBy());
        stockDto.setRealStock(stock.getItem().getRealStock());
        stockDto.setRemarks(stock.getItem().getRemarks());
        return stockDto;
    }
}
