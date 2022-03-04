package com.kodilla.cards.controller;

import com.kodilla.cards.dto.CardsDto;
import com.kodilla.cards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cards")
@RequiredArgsConstructor
public class CardsController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public List<CardsDto> getCards(@RequestParam("customerId") Long customerId) {
        return cardService.getCardsByCustomerId(customerId);
    }

    @PostMapping(value = "/addCard")
    public void addCards(@RequestBody CardsDto cardsDto) {
        if (cardsDto != null) {
            cardService.createCard(cardsDto);
        } else {
            throw new IllegalStateException("missing card");
        }
    }
}
