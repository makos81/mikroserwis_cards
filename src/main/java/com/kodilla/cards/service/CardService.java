package com.kodilla.cards.service;

import com.kodilla.cards.db.CardsRepository;
import com.kodilla.cards.domain.Cards;
import com.kodilla.cards.dto.CardsDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {
    private final ModelMapper modelMapper;
    private final CardsRepository cardsRepository;

    public List<CardsDto> getCardsByCustomerId(Long id) {
        return cardsRepository.findByCustomerId(id).stream()
                .map(card -> modelMapper.map(card, CardsDto.class))
                .collect(Collectors.toList());
    }

    public void createCard(CardsDto cardsDto) {
        Cards cards = modelMapper.map(cardsDto, Cards.class);
        cardsRepository.save(cards);
    }
}
