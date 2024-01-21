package com.greensuper.GreenSuper.services;


import com.greensuper.GreenSuper.dto.StripeChargeDto;
import com.greensuper.GreenSuper.dto.StripeTokenDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class StripeService {

    @Value("$api.stripe.key")
    private String stripeApiKey;



    @PostConstruct
    public void init(){
        Stripe.apiKey = stripeApiKey;
    }

    public StripeTokenDto createCardToken(StripeTokenDto model) {

        try {
            Map<String,Object> card = new HashMap<>();
            card.put("number",model.getCardNumber());
            card.put("exp_month",model.getExpMonth());
            card.put("exp_year",model.getExpYear());
            card.put("cvc",model.getCvc());
            Map<String,Object> params = new HashMap<>();
            params.put("card",card);
            com.stripe.model.Token token = Token.create(params);
            if (token != null) {
                model.setToken(token.getId());
                model.setSuccess(true);
            }return model;
        } catch (StripeException e) {
            log.error("StripeService.createCardToken()", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public StripeChargeDto charge(StripeChargeDto chargeRequest) {

        try {
            chargeRequest.setSuccess(false);
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", (int) (chargeRequest.getAmount() * 100));
            chargeParams.put("currency", "USD");
            chargeParams.put("description", "Payment for id " + chargeRequest.getAdditionalInfo().getOrDefault("ID_TAG", ""));
            chargeParams.put("source", chargeRequest.getStripeToken());
            Map<String, Object> metadata = new HashMap<>();
            metadata.put("id", chargeRequest.getChargeId());
            metadata.putAll(chargeRequest.getAdditionalInfo());
            chargeParams.put("metadata", metadata);
            Charge charge = Charge.create(chargeParams);
            chargeRequest.setMessage(charge.getOutcome().getSellerMessage());

            if (charge.getPaid())
                chargeRequest.setChargeId(charge.getId());
            chargeRequest.setSuccess(true);


        } catch (StripeException ex) {
            log.error("StripeService.charge()", ex);
            throw new RuntimeException(ex);
        }
        return chargeRequest;


    }



}
