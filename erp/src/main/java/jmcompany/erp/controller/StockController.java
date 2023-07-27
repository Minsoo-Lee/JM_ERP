package jmcompany.erp.controller;

import jmcompany.erp.domain.Item;
import jmcompany.erp.domain.Stock;
import jmcompany.erp.dto.ItemDto;
import jmcompany.erp.dto.StockDto;
import jmcompany.erp.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @GetMapping()
    public String getStockList(Model model) {
        model.addAttribute("stocks", stockService.findAll());
        return "stock/stockList";
    }

    @GetMapping("/new")
    public String createStockForm(Model model) {
        model.addAttribute("form", new StockDto());
        return "stock/createStockForm";
    }

    @PostMapping("/new")
    public String create(StockDto form) {
        Stock stock = Stock.createNewStock(form);
        stockService.join(stock);
        return "redirect:/stock";
    }

    @GetMapping("/{id}/edit")
    public String updateStockForm(@PathVariable("id") Long id, Model model) {
        Stock stock = stockService.findOne(id);
        StockDto form = StockDto.createNewForm(stock);
        model.addAttribute("form", form);
        return "stock/updateStockForm";
    }

    @PostMapping("/{id}/edit")
    public String updateStockForm(@PathVariable("id") Long id, StockDto form) {
        stockService.update(form);
        return "redirect:/stock";
    }
}
