package com.greensuper.GreenSuper.controller;


import com.greensuper.GreenSuper.dto.StripeChargeDto;
import com.greensuper.GreenSuper.dto.StripeTokenDto;
import com.greensuper.GreenSuper.services.StripeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stripe")
@AllArgsConstructor
public class StripeController {

    private final StripeService stripeService;


    @PostMapping("crate/token")
    public StripeTokenDto createCardtoken(StripeTokenDto stripeTokenDto) {
        return stripeService.createCardToken(stripeTokenDto);
    }


  /*  @PostMapping("/charge")
    @ResponseBody
    public StripeChargeDto charge(RequestBody StripeChargeDto model) {
        return stripeService.charge(model);
    }*/




}
