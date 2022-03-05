package com.kodilla.cards.controller;

import com.kodilla.cards.dto.CardsDto;
import com.kodilla.cards.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;


@WebMvcTest(CardsController.class)
public class CardsControllerTest {
    @MockBean
    private CardService cardService;
    @Autowired
    MockMvc mockMvc;

    String URI = "/v1/cards";

    @Test
    public void shouldFetchCardWhenExistForCustomerId() throws Exception {
        when(cardService.getCardsByCustomerId(2L)).thenReturn(createCard());

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get(URI)
                        .param("customerId", "2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]id").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]currency").value("PLN"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]accountNumber").value("123"))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    public void shouldReturnEmptyListWhenCustomerIdDoNotExist() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get(URI)
                        .param("customerId", "2")
        ).andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    private List<CardsDto> createCard() {
        return List.of(CardsDto.builder()
                .id(2L)
                .accountNumber("123")
                .currency("PLN")
                .customerId(23L)
                .build());
    }
}
