package jmcompany.erp.controller;

import jmcompany.erp.domain.Sell;
import jmcompany.erp.dto.SellDto;
import jmcompany.erp.service.SellService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sell")
@Slf4j
public class SellController {

    private final SellService sellService;

    @GetMapping()
    public String getSell(Model model) {
        model.addAttribute("sells", sellService.findAll());
        return "sell/sellList";
    }

    @GetMapping("/new")
    public String createSellForm(Model model) {
        model.addAttribute("form", new SellDto());
        return "sell/createSellForm";
    }

    @PostMapping("/new")
    public String create(SellDto form) {
        Sell sell = Sell.createNewSell(form);
        sellService.join(sell);
        return "redirect:/sell/" + sell.getId();
    }

    @GetMapping("/{id}")
    public String confirmNewSell(@PathVariable("id") Long id, Model model) {
        log.info("id = " + id);
        Sell sell = sellService.findOne(id);
        SellDto form = SellDto.createNewForm(sell);
        model.addAttribute("form", form);
        return "sell/confirmSellForm";
    }

    @PostMapping("/{id}")
    public String confirm(@PathVariable("id") Long id, SellDto form) {
        sellService.confirmEntity(id, form);
        return "redirect:/sell";
    }

    @GetMapping("/{id}/edit")
    public String updateSellForm(@PathVariable("id") Long id, Model model) {
        Sell sell = sellService.findOne(id);
        SellDto form = SellDto.createNewForm(sell);
        model.addAttribute("form", form);
        return "sell/updateSellForm";
    }

    @PostMapping("/{id}/edit")
    public String updateSellForm(@PathVariable("id") Long id, SellDto form) {
        sellService.update(id, form);
        return "redirect:/sell/" + form.getId();
    }
}
