package jmcompany.erp.controller;

import jmcompany.erp.domain.Buy;
import jmcompany.erp.dto.BuyDto;
import jmcompany.erp.service.BuyService;
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
@RequestMapping("/buy")
@Slf4j
public class BuyController {

    private final BuyService buyService;

    @GetMapping()
    public String getBuy(Model model) {
        model.addAttribute("buys", buyService.findAll());
        return "buy/buyList";
    }

    @GetMapping("/new")
    public String createBuyForm(Model model) {
        model.addAttribute("form", new BuyDto());
        return "buy/createBuyForm";
    }

    @PostMapping("/new")
    public String create(BuyDto form) {
        Buy buy = Buy.createNewBuy(form);
        buyService.join(buy);
        return "redirect:/buy/" + buy.getId();
    }

    @GetMapping("/{id}")
    public String confirmNewBuy(@PathVariable("id") Long id, Model model) {
        log.info("id = " + id);
        Buy buy = buyService.findOne(id);
        BuyDto form = BuyDto.createNewForm(buy);
        model.addAttribute("form", form);
        return "buy/confirmBuyForm";
    }

    @PostMapping("/{id}")
    public String confirm(@PathVariable("id") Long id, BuyDto form) {
        buyService.confirmEntity(id, form);
        return "redirect:/buy";
    }

    @GetMapping("/{id}/edit")
    public String updateBuyForm(@PathVariable("id") Long id, Model model) {
        Buy buy = buyService.findOne(id);
        BuyDto form = BuyDto.createNewForm(buy);
        model.addAttribute("form", form);
        return "buy/updateBuyForm";
    }

    @PostMapping("/{id}/edit")
    public String updateBuyForm(@PathVariable("id") Long id, BuyDto form) {
        buyService.update(id, form);
        return "redirect:/buy/" + form.getId();
    }
}
